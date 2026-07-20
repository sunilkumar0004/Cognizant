# 2. spring-rest-handson (spring-learn)

Spring Boot REST Controllers, Exception Handling, and MockMVC End-to-End Testing.

## Objectives Covered

1. **HTTP Request & Response**: Detailed documentation in `explanations.md`.
2. **Hello World REST Web Service**: `HelloController` handling `GET /hello` returning `"Hello World!!"`.
3. **REST Country Web Service**: `CountryController` handling `GET /country` returning India JSON (`{"code": "IN", "name": "India"}`).
4. **Get All Countries**: `CountryController` handling `GET /countries` returning list of 4 countries.
5. **Get Country By Code & Exception Handling**: `CountryService.getCountry(code)` with case-insensitive `@PathVariable` matching and `@ResponseStatus(value = HttpStatus.NOT_FOUND)` on `CountryNotFoundException`.
6. **MockMVC Testing**: End-to-End automated testing using `MockMvc`, `@AutoConfigureMockMvc`, `jsonPath()`, `status().isOk()`, and `status().isNotFound()`.

## How to Run

### Run Application:
```powershell
.\mvnw.cmd spring-boot:run
```

### Run Tests:
```powershell
.\mvnw.cmd clean test
```
