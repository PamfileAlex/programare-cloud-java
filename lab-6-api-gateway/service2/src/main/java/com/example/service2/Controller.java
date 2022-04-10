package com.example.service2;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class Controller {

    private List<Product> products = new ArrayList<Product>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void greeting(@RequestBody Product product, BindingResult result, @RequestHeader Map<String, String> headers) {
        printHeaders(headers);
        if (result.hasErrors()) {
            throw new RuntimeException("Product Exception");
        }
        products.add(product);
    }

    @GetMapping()
    public List<Product> greeting(@RequestHeader Map<String, String> headers) {
        printHeaders(headers);
        return products;
    }

    private void printHeaders(Map<String, String> headers) {
        System.out.println("HEADERS");
        headers.forEach((key, value) -> {
            System.out.printf("Header '%s' = %s%n", key, value);
        });
    }
}