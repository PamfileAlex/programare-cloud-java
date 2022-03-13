package com.unitbv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.unitbv.beans"})
public class HumanAppCfg {
    @Value("${book.title}")
    private String bookTitle;

    @Bean
    Book book() {
        return new Book(bookTitle);
    }

    @Bean
    @Autowired
    Person person(Book book) {
        return new Person(book);
    }
}
