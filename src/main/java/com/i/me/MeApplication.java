package com.i.me;

import com.samskivert.mustache.Mustache;
import org.apache.ibatis.mapping.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeApplication.class, args);
    }


}
