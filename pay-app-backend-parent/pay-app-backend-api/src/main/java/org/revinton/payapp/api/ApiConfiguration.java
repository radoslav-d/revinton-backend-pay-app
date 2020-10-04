package org.revinton.payapp.api;

import org.revinton.payapp.persistence.repositories.OfferRepository;
import org.revinton.payapp.persistence.repositories.PaymentMethodRepository;
import org.revinton.payapp.persistence.repositories.PlaceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Bean
    public PlaceRepository placeRepository() {
        return new PlaceRepository();
    }

    @Bean
    public OfferRepository offerRepository() {
        return new OfferRepository();
    }

    @Bean
    public PaymentMethodRepository paymentMethodRepository() {
        return new PaymentMethodRepository();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
//        Map<String, String> properties = new HashMap<>();
//        properties.put(EntityManagerProperties.JDBC_DRIVER, "org.postgresql.Driver");
//        properties.put(EntityManagerProperties.JDBC_URL, "postgres://...");
//        properties.put(EntityManagerProperties.JDBC_USER, "...");
//        properties.put(EntityManagerProperties.JDBC_PASSWORD, "...");
//
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setPersistenceProviderClass(org.eclipse.persistence.jpa.PersistenceProvider.class);
//        emf.setPackagesToScan("org.revinton.payapp.persistence");
//        emf.setPersistenceUnitName("...");
//        emf.setJpaPropertyMap(properties);
//        emf.setLoadTimeWeaver(new ReflectiveLoadTimeWeaver());
//        return emf;
//    }
}
