# JUnit Advanced Testing Exercises

This folder contains the solutions for the **Advanced JUnit Testing Exercises** built using **JUnit 5 (Jupiter)**.

## Project Structure
```
JUnit_Advanced Testing exercices/
├── lib/                             # Standalone JUnit Platform Console Launcher JAR
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── exercise/
│   │               ├── EvenChecker.java       # Target class for parameterized testing
│   │               ├── ExceptionThrower.java  # Target class for exception assertions
│   │               └── PerformanceTester.java # Target class for timeout testing
│   └── test/
│       └── java/
│           └── com/
│               └── exercise/
│                   ├── EvenCheckerTest.java   # Parameterized tests (Exercise 1)
│                   ├── AllTests.java          # Test Suite class (Exercise 2)
│                   ├── OrderedTests.java      # Ordered execution tests (Exercise 3)
│                   ├── ExceptionThrowerTest.java # Exception assertion tests (Exercise 4)
│                   └── PerformanceTesterTest.java # Timeout validation tests (Exercise 5)
├── pom.xml                          # Maven build setup with JUnit 5 dependencies
├── verify.ps1                       # Compilation and execution script
└── README.md                        # Documentation (this file)
```

---

## Exercise Details

### Exercise 1: Parameterized Tests
- **Goal:** Test a method with multiple input parameters in a single test case.
- **Implementation:**
  - `EvenChecker.isEven(int)` returns true for even integers.
  - `EvenCheckerTest` runs `@ParameterizedTest` with `@ValueSource` passing arrays of odd/even integers.

### Exercise 2: Test Suites and Categories
- **Goal:** Group and run multiple test classes together.
- **Implementation:**
  - Created the suite class `AllTests` annotated with `@Suite` and `@SelectClasses` specifying the list of test classes to run.

### Exercise 3: Test Execution Order
- **Goal:** Run tests in a strict user-defined order.
- **Implementation:**
  - `OrderedTests` uses `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` and `@Order(X)` tags to execute test cases sequentially (1, 2, 3).
  - Uses `@BeforeAll` to ensure clean environment state during multi-session runs.

### Exercise 4: Exception Testing
- **Goal:** Assert that a method throws the expected exception type and message.
- **Implementation:**
  - `ExceptionThrower` throws exceptions on invalid values.
  - `ExceptionThrowerTest` asserts exceptions using `assertThrows(Expected.class, executable)`.

### Exercise 5: Timeout and Performance Testing
- **Goal:** Confirm execution completes within an allotted time limit.
- **Implementation:**
  - `PerformanceTesterTest` showcases `assertTimeout(Duration, executable)` and `@Timeout(value = X, unit = Y)` annotations.

---

## How to Run the Tests

### Option A: Using the Automated PowerShell Script
Run the script to download the JUnit 5 standalone launcher, compile, and run the suite:
```powershell
.\verify.ps1
```

### Option B: Using an IDE
Open the folder in IntelliJ IDEA or Eclipse. The IDE will detect the Maven project defined in `pom.xml` and download the JUnit 5 libraries automatically.
