package com.example.swcoaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SwCoachingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwCoachingApplication.class, args);
  }

}