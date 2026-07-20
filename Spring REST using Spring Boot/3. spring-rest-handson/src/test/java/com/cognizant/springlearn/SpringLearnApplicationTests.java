package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.DepartmentController;
import com.cognizant.springlearn.controller.EmployeeController;
import com.cognizant.springlearn.dao.EmployeeDao;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private DepartmentController departmentController;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    @SuppressWarnings("unchecked")
    void resetData() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        Object freshList = context.getBean("employeeList");
        ReflectionTestUtils.setField(employeeDao, "EMPLOYEE_LIST", freshList);
    }

    @Test
    void contextLoads() {
        assertNotNull(employeeController);
        assertNotNull(departmentController);
    }

    @Test
    void testGetAllEmployees() throws Exception {
        ResultActions actions = mvc.perform(get("/employees"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$").isArray());
        actions.andExpect(jsonPath("$[0].name").value("John"));
        actions.andExpect(jsonPath("$[0].department.name").value("Payroll"));
    }

    @Test
    void testGetAllDepartments() throws Exception {
        ResultActions actions = mvc.perform(get("/departments"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$").isArray());
        actions.andExpect(jsonPath("$[0].name").value("Payroll"));
        actions.andExpect(jsonPath("$[1].name").value("HR"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        String updateJson = "{\"id\":1,\"name\":\"John Updated\",\"salary\":15000.0,\"permanent\":true,\"dateOfBirth\":\"01/01/1995\",\"department\":{\"id\":1,\"name\":\"Payroll\"},\"skills\":[{\"id\":1,\"name\":\"Java\"}]}";

        ResultActions actions = mvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson));

        actions.andExpect(status().isOk());
    }
}
