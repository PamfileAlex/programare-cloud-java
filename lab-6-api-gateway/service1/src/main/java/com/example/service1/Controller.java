package com.example.service1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name, @RequestHeader Map<String, String> headers) {
        System.out.println(name);
        printHeaders(headers);
        return "Hello " + name;
    }

    private void printHeaders(Map<String, String> headers) {
        System.out.println("HEADERS");
        headers.forEach((key, value) -> {
            System.out.printf("Header '%s' = %s%n", key, value);
        });
    }
}