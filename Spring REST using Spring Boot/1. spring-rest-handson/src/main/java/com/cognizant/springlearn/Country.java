package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // Hands-on 4: No-arg constructor with debug logging
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        LOGGER.debug("Inside Country Parameterized Constructor.");
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        LOGGER.debug("Inside getCode() getter.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode() setter with value: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName() getter.");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName() setter with value: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
