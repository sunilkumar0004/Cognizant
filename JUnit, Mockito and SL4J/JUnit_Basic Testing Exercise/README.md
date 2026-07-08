# JUnit Basic Testing Exercises

This folder contains the consolidated solutions for the **JUnit Basic Testing Exercises**.

## Project Structure
```
JUnit_Basic Testing Exercise/
├── lib/                             # Downloaded dependency jars (JUnit & Hamcrest)
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── exercise/
│   │               └── Calculator.java       # Target class under test
│   └── test/
│       └── java/
│           └── com/
│               └── exercise/
│                   └── CalculatorTest.java   # Consolidated test suite for all exercises
├── pom.xml                          # Maven configuration (Exercise 1)
├── verify.ps1                       # Compilation & test execution script
└── README.md                        # Documentation (this file)
```

---

## Exercise Details & Consolidation

### Exercise 1: Setting Up JUnit
- **Goal:** Set up JUnit dependency in a Java project.
- **Implementation:** Added the JUnit 4.13.2 dependency to `pom.xml`.

### Exercise 2: Writing Basic JUnit Tests
- **Goal:** Write basic unit tests for a target class.
- **Implementation:** Created the `Calculator` class with arithmetic methods (`add`, `subtract`, `multiply`, `divide`). Basic tests for success paths and expected exception behaviors are covered in `CalculatorTest.java`.

### Exercise 3: Assertions in JUnit
- **Goal:** Implement different types of JUnit assertions.
- **Implementation:** Consolidated into the `testAssertionsDemo()` method in `CalculatorTest.java`, showcasing:
  - `assertEquals()`
  - `assertTrue()`
  - `assertFalse()`
  - `assertNull()`
  - `assertNotNull()`

### Exercise 4: AAA Pattern & Test Fixtures
- **Goal:** Organize tests using the Arrange-Act-Assert (AAA) pattern and use setup/teardown methods.
- **Implementation:**
  - Used `@Before` (`setUp()`) to instantiate the `Calculator` before each test.
  - Used `@After` (`tearDown()`) to clean up/dereference the `Calculator` after each test.
  - Inline comments inside `testBasicOperationsWithAAAPattern()` demonstrate the **Arrange**, **Act**, and **Assert** phases clearly.

---

## How to Run the Tests

### Option A: Using the Automated PowerShell Script
Run the following script to compile the files and run the tests:
```powershell
.\verify.ps1
```

### Option B: Using an IDE
You can open this folder (`JUnit_Basic Testing Exercise`) directly in IntelliJ IDEA, Eclipse, or VS Code as a Maven project. The IDE will resolve the dependencies in `pom.xml` automatically.
