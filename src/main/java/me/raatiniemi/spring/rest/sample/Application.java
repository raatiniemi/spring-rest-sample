package me.raatiniemi.spring.rest.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String... args) {
        System.out.println("Booting application...");

        SpringApplication.run(Application.class, args);
    }
}
