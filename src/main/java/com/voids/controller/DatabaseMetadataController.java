package com.voids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DatabaseMetadataController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@GetMapping("/column-names")
    public List<Map<String, Object>> getColumnNames() {
        // Replace "your_table_name" with the actual table name
        String tableName = "incoming_inventory";
        return jdbcTemplate.queryForList("SELECT column_name,data_type FROM information_schema.columns WHERE table_name = ?", tableName);
    }*/

    @GetMapping("/table-names")
    public List<String> getTableNames() {
        return jdbcTemplate.queryForList("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'", String.class);
    }
}

