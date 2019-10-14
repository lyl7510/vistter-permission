package com.base.vistter.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.base.vistter.system.*")
public class VistterSystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(VistterSystemApplication.class, args);
    }

}
