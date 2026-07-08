# Mockito Hands-On Exercises

This folder contains the solutions for the **Mockito Hands-On Exercises** built using **JUnit 5 (Jupiter)** and **Mockito 5**.

## Project Structure
```
Mockito exercises/
├── lib/                             # External library dependency JARs (Mockito, JUnit, etc.)
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── exercise/
│   │               ├── ExternalApi.java     # The mocked interface
│   │               └── MyService.java       # The service class depending on ExternalApi
│   └── test/
│       └── java/
│           └── com/
│               └── exercise/
│                   └── MyServiceTest.java   # Tests solving all 7 Mockito Exercises
├── pom.xml                          # Maven build file with dependency declarations
└── verify.ps1                       # PowerShell verification and test execution script
```

## Implemented Exercises

### [Exercise 1: Mocking and Stubbing](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L11-L22)
- **Goal**: Mock the external API and stub `getData()` to return a predefined value (`"Mock Data"`).
- **Test Method**: `testExternalApi()`

### [Exercise 2: Verifying Interactions](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L24-L33)
- **Goal**: Verify that the `getData()` method is called during service operations.
- **Test Method**: `testVerifyInteraction()`

### [Exercise 3: Argument Matching](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L35-L47)
- **Goal**: Stub the method to accept any integer and verify matching argument calls.
- **Test Method**: `testArgumentMatching()`

### [Exercise 4: Handling Void Methods](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L49-L59)
- **Goal**: Stub a void method (`saveData`) using `doNothing()` and verify its invocation.
- **Test Method**: `testHandlingVoidMethods()`

### [Exercise 5: Mocking and Stubbing with Multiple Returns](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L61-L74)
- **Goal**: Stub a method to return different results on consecutive calls (`"First Call"`, `"Second Call"`).
- **Test Method**: `testMockingMultipleReturns()`

### [Exercise 6: Verifying Interaction Order](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L76-L88)
- **Goal**: Verify that methods are called in a specific sequence (`authenticate` followed by `getData`) using `InOrder`.
- **Test Method**: `testVerifyingInteractionOrder()`

### [Exercise 7: Handling Void Methods with Exceptions](file:///c:/Users/NELAESH/OneDrive/Desktop/Cognizant/JUnit,%20Mockito%20and%20SL4J/Mockito%20exercises/src/test/java/com/exercise/MyServiceTest.java#L90-L105)
- **Goal**: Stub a void method (`deleteData`) to throw an exception for specific parameters and verify.
- **Test Method**: `testVoidMethodWithExceptions()`

---

## Running the Verification Script

Run the PowerShell verification script to download target dependencies, compile all files, and execute the test runner:

```powershell
.\verify.ps1
```
