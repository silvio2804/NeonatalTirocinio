package com.example.neoproject;

import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Reparto;
import com.example.neoproject.repository.PostolettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class NeoProjectApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("-------numero di processori usati "+Runtime.getRuntime().availableProcessors()+" -----------");
        return builder.sources(NeoProjectApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("-------numero di processori usati " + Runtime.getRuntime().availableProcessors() + " -----------");

        SpringApplication.run(NeoProjectApplication.class, args);
    }
}
