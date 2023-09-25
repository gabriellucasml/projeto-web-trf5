package com.triagem.api;

import com.triagem.api.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ApiTriagemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApiTriagemApplication.class, args);
    }
}
