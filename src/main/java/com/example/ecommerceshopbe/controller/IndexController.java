package com.example.ecommerceshopbe.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Getter
public class IndexController {

    private static final String GREET_MESSAGE = "Application is running";

    @GetMapping
    public String getGreetMessage() {
        return GREET_MESSAGE;
    }

    @GetMapping("/hello")
    public List<String> getAllUsers() {
        List<String> result = new ArrayList<>();
        result.add("Hello");
        result.add("ciao");
        return result;
    }
}
