package com.heron.lee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heron.lee 2020/10/13
 */
@RestController
public class SystemController {

    @GetMapping(value = { "/", "/health-check" })
    public ResponseEntity<String> healthCheck () {
        return ResponseEntity.ok("OK");
    }
}
