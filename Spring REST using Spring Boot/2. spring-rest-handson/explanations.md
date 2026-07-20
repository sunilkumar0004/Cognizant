# Spring REST Hands-on 2 - Explanations

---

## 1. HTTP Request and Response Format

### HTTP Request Format
An HTTP request consists of three main parts:
1. **Request Line**: Contains Method (`GET`, `POST`, `PUT`, `DELETE`), Resource URI (`/hello.txt`), and HTTP Version (`HTTP/1.1`).
2. **Request Headers**: Key-value pairs describing client metadata (`Host`, `User-Agent`, `Accept`, `Content-Type`, `Authorization`).
3. **Request Body (Payload)**: Optional content sent by client (e.g. JSON or XML payload for POST/PUT requests).

```http
GET /hello HTTP/1.1
Host: localhost:8083
User-Agent: Mozilla/5.0
Accept: application/json
```

### HTTP Response Format
An HTTP response consists of:
1. **Status Line**: HTTP Version, Status Code (`200`, `404`, `500`), and Reason Phrase (`OK`, `Not Found`).
2. **Response Headers**: Metadata sent by server (`Content-Type`, `Content-Length`, `Date`, `Server`).
3. **Response Body**: Data returned by server (e.g. JSON `{"code":"IN","name":"India"}`).

```http
HTTP/1.1 200 OK
Content-Type: application/json
Date: Mon, 20 Jul 2026 10:00:00 GMT

{
  "code": "IN",
  "name": "India"
}
```

---

## 2. Benefits of RESTful Web Services
- **Stateless & Scalable**: Each request contains all information necessary to process it. Server does not hold client session state.
- **Uniform Interface**: Uses standard HTTP verbs (`GET`, `POST`, `PUT`, `DELETE`) operating on resources identified by URLs.
- **Format Decoupling**: Data is commonly serialized as lightweight JSON (`application/json`) or XML (`application/xml`).
- **Client-Server Separation**: Frontend (web/mobile) and backend can evolve independently.

---

## 3. DispatcherServlet & `@RestController` Mechanism
- **`DispatcherServlet`**: Front Controller in Spring MVC that intercepts incoming HTTP requests and routes them to appropriate controller handler methods.
- **`@RestController`**: Combination of `@Controller` and `@ResponseBody`. Automatically serializes Java objects returned by handler methods directly into JSON/XML HTTP response payload using Jackson message converters.
- **`@PathVariable`**: Binds URI template placeholder variables (e.g. `/country/{code}`) to method arguments.

---

## 4. Exception Handling with `@ResponseStatus`
- Annotating custom exceptions like `CountryNotFoundException` with `@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")` instructs Spring MVC to translate thrown exceptions into HTTP 404 response status with standard JSON error payload.

---

## 5. End-to-End Testing with MockMVC
- **`@AutoConfigureMockMvc`**: Auto-configures Spring `MockMvc` infrastructure without spinning up a full HTTP web server.
- **`MockMvc`**: Simulates HTTP requests (`get("/country")`) and validates responses (`andExpect(status().isOk())`, `andExpect(jsonPath("$.code").value("IN"))`).
