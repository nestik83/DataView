# DataView

Starter web application for viewing data from Oracle Database.

## Stack

- Java 21
- Spring Boot 3.5.6
- Maven
- Spring MVC and Thymeleaf
- Spring JDBC (`JdbcTemplate`)
- Oracle JDBC (`ojdbc11`)

## Run locally

Set `ORACLE_URL`, `ORACLE_USER`, and `ORACLE_PASSWORD`, then run:

```bash
mvn spring-boot:run
```

## Run with Docker Compose

1. Copy the example environment file:

   ```bash
   cp .env.example .env
   ```

2. Edit `.env` and set the Oracle connection URL, username, and password. For example:

   ```dotenv
   ORACLE_URL=jdbc:oracle:thin:@//db-host:1521/ORCLPDB1
   ORACLE_USER=your_username
   ORACLE_PASSWORD=your_password
   SERVER_PORT=8080
   ```

3. Build the image and start the container:

   ```bash
   docker compose up --build -d
   ```

4. Open http://localhost:8080. View logs with `docker compose logs -f dataview` and stop with `docker compose down`.

If Oracle runs on the same machine as Docker, `host.docker.internal` is mapped to the host gateway by the Compose configuration. If Oracle is on another server, use that server's DNS name or IP in `ORACLE_URL`. Ensure the Oracle listener is reachable from the Docker host.

The `.env` file is excluded from Git. Do not commit database credentials.

The initial page checks the Oracle connection with a read-only query against `DUAL`.
