package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message: Initializing configuration setup...");
        logger.info("Info message: Application started successfully.");
        logger.warn("Warn message: Connection response time is slow.");
        logger.error("Error message: Database connection failed!");
    }
}
