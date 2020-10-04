package org.revinton.payapp.web.application;

import org.revinton.payapp.api.resources.OffersResource;
import org.revinton.payapp.api.resources.PaymentMethodsResource;
import org.revinton.payapp.api.resources.PingResource;
import org.revinton.payapp.api.providers.GsonMessageBodyReader;
import org.revinton.payapp.api.providers.GsonMessageBodyWriter;
import org.revinton.payapp.api.providers.PayAppExceptionMapper;
import org.revinton.payapp.api.resources.PlacesResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class PayApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(GsonMessageBodyWriter.class);
        classes.add(GsonMessageBodyReader.class);
        classes.add(PayAppExceptionMapper.class);
        classes.add(PingResource.class);
        classes.add(PlacesResource.class);
        classes.add(OffersResource.class);
        classes.add(PaymentMethodsResource.class);
        return classes;
    }
}
