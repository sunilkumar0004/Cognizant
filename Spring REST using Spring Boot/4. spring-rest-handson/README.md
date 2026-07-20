# 4. spring-rest-handson (spring-learn)

Spring REST POST, PUT, DELETE Services with Input Validation and Global Exception Handling.

## Objectives Covered

1. **REST Standards**: URL naming guidelines & HTTP method conventions documented in `explanations.md`.
2. **POST Country Web Service**: `CountryController.addCountry(@RequestBody @Valid Country country)`.
3. **Bean Validation**: Added `@NotNull`, `@NotBlank`, `@Size(min=2, max=2)`, `@Min`, and `@Valid` across `Country`, `Employee`, `Department`, and `Skill`.
4. **Global Exception Handler**: `GlobalExceptionHandler` extending `ResponseEntityExceptionHandler` with `@ControllerAdvice` handling `MethodArgumentNotValidException` and `HttpMessageNotReadableException`.
5. **PUT & DELETE Employee Web Services**: `updateEmployee` and `deleteEmployee` methods in `EmployeeController` and `EmployeeDao` throwing `EmployeeNotFoundException`.
6. **MockMVC Automated Tests**: Unit & integration tests for valid POST/PUT/DELETE calls and 400 Bad Request / 404 Not Found error responses.

## How to Run

### Run Application:
```powershell
.\mvnw.cmd spring-boot:run
```

### Run Tests:
```powershell
.\mvnw.cmd clean test
```
