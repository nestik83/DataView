# DataView

Starter web application for viewing data from Oracle Database.

## Stack

- Java 21
- Spring Boot 3.5.6
- Maven
- Spring MVC and Thymeleaf
- Spring JDBC (`JdbcTemplate`)
- Oracle JDBC (`ojdbc11`)

## Run

Set `ORACLE_URL`, `ORACLE_USER`, and `ORACLE_PASSWORD`, then run:

```bash
mvn spring-boot:run
```

Open http://localhost:8080. The initial page checks the Oracle connection with a read-only query against `DUAL`.
