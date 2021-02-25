package com.example.swipecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author aaron
 */
@ServletComponentScan
@SpringBootApplication
public class SwipeCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwipeCardApplication.class, args);
    }

}
