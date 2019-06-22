package com.base.vistter;

import com.base.vistter.listener.InitializeReadModelListener;
import com.base.vistter.listener.InitializeWriteModelListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*import org.springframework.cloud.netflix.eureka.EnableEurekaClient;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@EnableEurekaClient*/
@ComponentScan(basePackages = {"com.base.vistter.*"})
public class VistterPermissionApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VistterPermissionApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(VistterPermissionApplication.class, args);
    }
    @Bean
    public InitializeReadModelListener initReadModel(){
        return new InitializeReadModelListener();
    }
    @Bean
    public InitializeWriteModelListener initWriteModel() {
        return new InitializeWriteModelListener();
    }
}
