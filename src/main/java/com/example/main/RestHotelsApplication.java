package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages={
        "com.example.models"

})
@EnableJpaRepositories(basePackages={
        "com.example.repositories"
})

@SpringBootApplication(scanBasePackages= {
        "com.example.data",
        "com.example.controllers",
        "com.example.exceptions"
})
public class RestHotelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestHotelsApplication.class, args);
    }

}
