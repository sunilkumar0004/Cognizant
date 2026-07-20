package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.controller.EmployeeController;
import com.cognizant.springlearn.dao.EmployeeDao;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private EmployeeController employeeController;

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
        assertNotNull(countryController);
        assertNotNull(employeeController);
    }

    @Test
    void testAddCountrySuccess() throws Exception {
        String countryJson = "{\"code\":\"FR\",\"name\":\"France\"}";
        ResultActions actions = mvc.perform(post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(countryJson));

        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").value("FR"));
        actions.andExpect(jsonPath("$.name").value("France"));
    }

    @Test
    void testAddCountryValidationError() throws Exception {
        String countryJson = "{\"code\":\"F\",\"name\":\"France\"}";
        ResultActions actions = mvc.perform(post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(countryJson));

        actions.andExpect(status().isBadRequest());
        actions.andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
    }

    @Test
    void testUpdateEmployeeSuccess() throws Exception {
        String updateJson = "{\"id\":1,\"name\":\"John Updated\",\"salary\":15000.0,\"permanent\":true,\"dateOfBirth\":\"01/01/1995\",\"department\":{\"id\":1,\"name\":\"Payroll\"},\"skills\":[{\"id\":1,\"name\":\"Java\"}]}";

        ResultActions actions = mvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson));

        actions.andExpect(status().isOk());
    }

    @Test
    void testUpdateEmployeeNotFound() throws Exception {
        String updateJson = "{\"id\":99,\"name\":\"Unknown\",\"salary\":15000.0,\"permanent\":true,\"dateOfBirth\":\"01/01/1995\",\"department\":{\"id\":1,\"name\":\"Payroll\"},\"skills\":[{\"id\":1,\"name\":\"Java\"}]}";

        ResultActions actions = mvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson));

        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Employee not found"));
    }

    @Test
    void testDeleteEmployeeSuccess() throws Exception {
        ResultActions actions = mvc.perform(delete("/employees/1"));
        actions.andExpect(status().isOk());
    }

    @Test
    void testDeleteEmployeeNotFound() throws Exception {
        ResultActions actions = mvc.perform(delete("/employees/99"));
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Employee not found"));
    }
}
