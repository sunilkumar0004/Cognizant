package com.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    public void testTaskCompletesWithinTimeout() {
        // Assert that the performance task completes within 100 milliseconds
        assertTimeout(Duration.ofMillis(100), () -> {
            tester.performTask(20); // Simulates a task taking 20ms
        });
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testTaskAnnotationTimeout() {
        tester.performTask(50); // Simulates a task taking 50ms, which is well within 200ms limit
    }
}
