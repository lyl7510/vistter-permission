package com.base.vistter.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.base.vistter.system.*")
public class VistterTomcatSystemApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VistterTomcatSystemApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VistterTomcatSystemApplication.class);
    }
}
