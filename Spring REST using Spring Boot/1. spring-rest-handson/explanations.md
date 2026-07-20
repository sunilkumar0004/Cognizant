# Spring REST Hands-on 1 - Explanations

---

## 1. Need and Benefits of Spring Boot
- **Simplified Development**: Eliminates complex XML configuration files in favor of annotation-driven auto-configuration.
- **Embedded Web Server**: Embedded Tomcat/Jetty server allows standalone execution (`java -jar`).
- **Starter Dependencies**: Opinionated POM dependencies reduce version mismatch issues (`spring-boot-starter-web`).
- **Production-ready Features**: Includes health checks, metrics, and externalized configuration out of the box.

---

## 2. Spring IoC Container & Bean Lifecycle
- **`ApplicationContext` / `ClassPathXmlApplicationContext`**: Central interface for providing configuration to an application.
- **Bean Definition (`<bean>`)**: Defines an object managed by the Spring IoC container (`id`, `class`, `scope`, `<property>`, `<constructor-arg>`).
- **Dependency Injection**:
  - **Constructor Injection**: Injected via `<constructor-arg>`.
  - **Setter Injection**: Injected via `<property name="..." value="..." />`.

---

## 3. Bean Scopes
- **Singleton (Default)**: Spring IoC container creates exactly one instance of the bean. Subsequent `context.getBean()` calls return the same instance reference.
- **Prototype**: Spring IoC container creates a new bean instance every time `context.getBean()` is requested (constructors and setters run per request).

---

## 4. Logging in Spring Boot
- Log levels configured via `application.properties`:
  ```properties
  logging.level.org.springframework=info
  logging.level.com.cognizant.springlearn=debug
  logging.pattern.console=%d{yyMMdd}|%d{HH:mm:ss.SSS}|%-20.20thread|%5p|%-25.25logger{25}|%25M|%m%n
  ```
- Uses SLF4J `LoggerFactory.getLogger(SpringLearnApplication.class)` for logging method entry (`LOGGER.info("START")`), debug outputs (`LOGGER.debug(...)`), and method exit (`LOGGER.info("END")`).
