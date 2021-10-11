package com.mooye.navicatim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.mooye.business.*")
public class NavicatImApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(NavicatImApplication.class, args);
    }
    
}
