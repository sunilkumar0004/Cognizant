package com.cognizant.springlearn;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringLearnApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testDateFormatBean() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        assertThat(format).isNotNull();

        Date date = format.parse("31/12/2018");
        assertThat(date).isNotNull();
    }

    @Test
    void testCountryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        assertThat(country).isNotNull();
        assertThat(country.getCode()).isEqualTo("IN");
        assertThat(country.getName()).isEqualTo("India");
    }

    @Test
    void testCountryListBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countries = (List<Country>) context.getBean("countryList");
        assertThat(countries).hasSize(4);
        assertThat(countries.get(0).getCode()).isEqualTo("IN");
        assertThat(countries.get(1).getCode()).isEqualTo("US");
        assertThat(countries.get(2).getCode()).isEqualTo("DE");
        assertThat(countries.get(3).getCode()).isEqualTo("JP");
    }
}
