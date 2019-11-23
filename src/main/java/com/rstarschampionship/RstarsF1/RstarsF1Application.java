package com.rstarschampionship.RstarsF1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.rstarschampionship.RstarsF1.repositories"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.rstarschampionship.RstarsF1.entity"})
public class RstarsF1Application {


    public static void main(String[] args) {
        SpringApplication.run(RstarsF1Application.class, args);
    }

}
