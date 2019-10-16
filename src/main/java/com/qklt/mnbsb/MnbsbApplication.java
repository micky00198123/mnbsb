package com.qklt.mnbsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
        //(exclude = {DataSourceAutoConfiguration.class})
public class MnbsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MnbsbApplication.class, args);
    }

}
