package com.cognizant.orm_learn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        // Hands on 1: Test get all countries
        testGetAllCountries();

        // Hands on 6: Find a country based on country code
        testFindCountryByCode();

        // Hands on 7: Add a new country
        testAddCountry();

        // Hands on 8: Update a country based on code
        testUpdateCountry();

        // Hands on 9: Delete a country based on code
        testDeleteCountry();

        // Hands on 5: Find list of countries matching a partial country name
        testFindCountryByNameContaining();

        LOGGER.info("All tests completed successfully!");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries. Count: {}", countries.size());
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country fetched: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        
        // Test not found path
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Expected Exception caught successfully: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("XX", "TestCountry");
        countryService.addCountry(newCountry);
        
        try {
            Country fetched = countryService.findCountryByCode("XX");
            LOGGER.debug("Added country successfully fetched: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to fetch added country: {}", e.getMessage());
        }
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("XX", "UpdatedTestCountry");
            Country fetched = countryService.findCountryByCode("XX");
            LOGGER.debug("Updated country: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to update country: {}", e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("XX");
        
        try {
            countryService.findCountryByCode("XX");
            LOGGER.error("Country XX was not deleted!");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Verified deletion successfully: Country XX not found.");
        }
        LOGGER.info("End testDeleteCountry");
    }

    private static void testFindCountryByNameContaining() {
        LOGGER.info("Start testFindCountryByNameContaining");
        List<Country> countries = countryService.findCountryByNameContaining("ou");
        LOGGER.debug("Countries matching 'ou': {}", countries);
        LOGGER.info("End testFindCountryByNameContaining. Found: {}", countries.size());
    }
}
