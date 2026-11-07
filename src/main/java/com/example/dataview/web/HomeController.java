package com.example.dataview.web;

import com.example.dataview.oracle.OracleStatusService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {
    private final OracleStatusService oracleStatusService;

    public HomeController(OracleStatusService oracleStatusService) {
        this.oracleStatusService = oracleStatusService;
    }

    @GetMapping("/")
    public String index(Model model) {
        try {
            model.addAttribute("oracleStatus", oracleStatusService.getStatus());
            model.addAttribute("connected", true);
        } catch (DataAccessException exception) {
            model.addAttribute("connected", false);
            model.addAttribute("errorMessage",
                    "Не удалось выполнить запрос к Oracle. Проверьте настройки подключения и доступность БД.");
        }
        return "index";
    }

    @GetMapping("/api/oracle/status")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> oracleStatus() {
        try {
            return ResponseEntity.ok(oracleStatusService.getStatus());
        } catch (DataAccessException exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("status", "ERROR",
                            "message", "Oracle database is unavailable or the query failed"));
        }
    }
}
