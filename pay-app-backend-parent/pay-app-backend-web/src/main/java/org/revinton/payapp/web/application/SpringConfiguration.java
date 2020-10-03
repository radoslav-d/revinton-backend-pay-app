package org.revinton.payapp.web.application;

import com.google.gson.Gson;
import org.revinton.payapp.SpringComponentScanMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringComponentScanMarker.class)
public class SpringConfiguration {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
