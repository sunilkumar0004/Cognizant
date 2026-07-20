# Spring REST Hands-on 4 - Explanations

---

## 1. Significance of HTTP Method Types in RESTful Web Services

| HTTP Method | Usage Scenario | Description |
|---|---|---|
| **GET** | Read resource(s) | Retrieves a representation of a resource without altering state. |
| **POST** | Create resource | Creates a new resource using data in the request body payload. |
| **PUT** | Update resource | Updates an existing resource using data in the request body payload. |
| **DELETE** | Delete resource | Removes a specific resource identified by URL path. |

*Note*: The HTTP method type is a semantic classification protocol. The application layer (Service/DAO) is responsible for executing persistence/memory modifications.

---

## 2. RESTful Resource Naming Conventions

- **Plural Nouns**: Resources are named in plural form (e.g. `/countries`, `/employees`, `/departments`).
- **Hyphenation**: Multi-word resource names use hyphens (`/menu-items`), not underscores.
- **Uniform Base URL**: Standard URL structure per resource:
  - `GET /countries`: Get all countries
  - `GET /countries/{code}`: Get country by code
  - `POST /countries`: Create a new country
  - `PUT /countries`: Update a country
  - `DELETE /countries/{code}`: Delete a country

---

## 3. Bean Validation (`javax.validation` Annotations)
- **`@NotNull`**: Ensures value is not null.
- **`@NotBlank`**: Ensures String contains non-whitespace characters.
- **`@Size(min=2, max=2)`**: Enforces exact length constraints (e.g. 2-character country code).
- **`@Min(value=0)`**: Enforces numeric lower bound constraints.
- **`@Valid`**: Cascades validation into nested objects/lists (`Department`, `List<Skill>`).

---

## 4. Global Exception Handling (`@ControllerAdvice`)
- **`GlobalExceptionHandler`** extends `ResponseEntityExceptionHandler`.
- Intercepts `MethodArgumentNotValidException` thrown when `@Valid` check fails:
  - Extracts field error messages.
  - Constructs custom JSON error response containing `timestamp`, `status` (400), and `errors` list.
- Intercepts `HttpMessageNotReadableException`:
  - Handles number format and type mismatch errors (e.g. passing a string into numeric `id`).
