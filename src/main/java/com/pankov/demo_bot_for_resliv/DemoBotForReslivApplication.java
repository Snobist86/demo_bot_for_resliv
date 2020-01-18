package com.pankov.demo_bot_for_resliv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class DemoBotForReslivApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(DemoBotForReslivApplication.class, args);
    }

}
