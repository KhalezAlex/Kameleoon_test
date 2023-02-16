package org.klozevitz.kameleoon_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KameloonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KameloonTestApplication.class, args);
    }

}
