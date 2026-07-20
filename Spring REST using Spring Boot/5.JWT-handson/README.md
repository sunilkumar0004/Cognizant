# 5.JWT-handson (spring-learn)

JWT Authentication for Spring Boot RESTful Web Services using Spring Security.

## Objectives Covered

1. **Spring Security Configuration**: `SecurityConfig` extending `WebSecurityConfigurerAdapter` configuring in-memory authentication (`user`/`pwd`, `admin`/`pwd`) and BCrypt password encoder.
2. **Authentication Controller**: `AuthenticationController` handling `GET /authenticate` with `@RequestHeader("Authorization")`, decoding Base64 credentials, generating signed JWT tokens (`HS256`, 20-min expiration) via JJWT library.
3. **JWT Authorization Filter**: `JwtAuthorizationFilter` extending `BasicAuthenticationFilter`, intercepting `Authorization: Bearer <token>` headers, validating claims, and updating `SecurityContextHolder`.
4. **Endpoint Protection**: `/countries`, `/departments`, and `/employees` protected behind JWT token authorization.
5. **MockMVC Unit & Integration Tests**: Integration test suite verifying HTTP Basic token issuance, 401 Unauthorized responses, valid Bearer token requests, and invalid token handling.

## How to Run

### Run Application:
```powershell
.\mvnw.cmd spring-boot:run
```

### Run Tests:
```powershell
.\mvnw.cmd clean test
```
