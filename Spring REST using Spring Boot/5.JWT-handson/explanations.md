# Spring REST Hands-on 5 - JWT Explanations

---

## 1. What is JWT (JSON Web Token)?
- **JSON Web Token (JWT)** (RFC 7519) is a compact, URL-safe means of representing claims to be transferred between two parties.
- Eliminates the need for server-side HTTP session state in stateless REST APIs.

---

## 2. JWT Process Flow
1. **Client Authenticates**: Sends HTTP Basic Authorization header (`user:pwd`) to `/authenticate`.
2. **Server Validates Credentials & Issues Token**: `AuthenticationController` validates credentials, builds a JWT signed with `HS256` and secret key, and returns `{"token": "<JWT_STRING>"}`.
3. **Client Attaches Token**: Client attaches token in subsequent HTTP requests as `Authorization: Bearer <JWT_STRING>`.
4. **Filter Authorizes Requests**: `JwtAuthorizationFilter` intercepts requests, parses/validates claims using `Jwts.parser()`, and sets `SecurityContextHolder` authentication.

---

## 3. JWT Structure
JWT consists of 3 dot-separated Base64Url parts:
1. **Header**: Algortihm & token type (`{"alg": "HS256", "typ": "JWT"}`).
2. **Payload (Claims)**: Data claims such as subject (`sub`), issued time (`iat`), expiration (`exp`).
3. **Signature**: Cryptographic signature calculated as `HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)`.

---

## 4. HTTP Basic Limitations vs JWT
- **HTTP Basic**: Credentials (`user:pwd`) are Base64 encoded and sent on *every* request. Anyone intercepting the HTTP request can instantly decode `user:pwd` using Base64.
- **JWT**: Credentials are sent *once* to `/authenticate`. The issued token is time-limited (e.g. 20 min expiry) and cryptographically signed, preventing tampering.
