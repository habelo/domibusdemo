package com.tdialog.domibusdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@SpringBootApplication
public class DomibusdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DomibusdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started");
    }
}
