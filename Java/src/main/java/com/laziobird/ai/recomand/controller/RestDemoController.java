package com.laziobird.ai.recomand.controller;

import com.laziobird.ai.recomand.dto.DemoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {
    private static final String template = "Hello, %s!";
    @GetMapping("/greeting")
    public DemoDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new DemoDTO(String.format(template, name));
    }
}
