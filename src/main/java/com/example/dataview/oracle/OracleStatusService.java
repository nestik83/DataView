package com.example.dataview.oracle;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OracleStatusService {
    private static final String STATUS_SQL = """
            SELECT
                SYS_CONTEXT('USERENV', 'DB_NAME') AS DB_NAME,
                SYS_CONTEXT('USERENV', 'SESSION_USER') AS SESSION_USER,
                TO_CHAR(SYSTIMESTAMP, 'YYYY-MM-DD HH24:MI:SS.FF3 TZH:TZM') AS DB_TIME
            FROM DUAL
            """;

    private final JdbcTemplate jdbcTemplate;

    public OracleStatusService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> getStatus() {
        return jdbcTemplate.queryForMap(STATUS_SQL);
    }
}
