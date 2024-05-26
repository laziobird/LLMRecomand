package com.laziobird.ai.recomand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class AiRecomandApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiRecomandApplication.class, args);
    }


    @PostConstruct
    public void init() {
        log.info("====PostConstruct End=====");

    }
}
