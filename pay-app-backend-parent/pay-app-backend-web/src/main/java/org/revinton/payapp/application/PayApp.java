package org.revinton.payapp.application;

import org.revinton.payapp.api.PingResource;
import org.revinton.payapp.providers.GsonMessageBodyReader;
import org.revinton.payapp.providers.GsonMessageBodyWriter;
import org.revinton.payapp.providers.PayAppExceptionMapper;

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
        // TODO add classes, like rest controllers and etc, which needs to be initialized
        return classes;
    }
}
