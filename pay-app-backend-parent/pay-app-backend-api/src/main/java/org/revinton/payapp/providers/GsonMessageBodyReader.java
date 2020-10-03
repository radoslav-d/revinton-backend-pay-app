package org.revinton.payapp.providers;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class GsonMessageBodyReader<T> implements MessageBodyReader<T> {

    private Gson gson;

    @Inject
    public GsonMessageBodyReader(Gson gson) {
        this.gson = gson;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        return readFrom(entityStream, MediaUtil.getCharset(mediaType), type);
    }

    private T readFrom(InputStream entityStream, Charset charset, Class<T> type) {
        return gson.fromJson(new InputStreamReader(entityStream, charset), type);
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }
}