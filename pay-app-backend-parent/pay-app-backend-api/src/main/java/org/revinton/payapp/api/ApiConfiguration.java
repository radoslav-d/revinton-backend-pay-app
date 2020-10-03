package org.revinton.payapp.api;

import org.revinton.payapp.persistence.repositories.PlaceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Bean
    public PlaceRepository placeRepository() {
        return new PlaceRepository();
    }
}
