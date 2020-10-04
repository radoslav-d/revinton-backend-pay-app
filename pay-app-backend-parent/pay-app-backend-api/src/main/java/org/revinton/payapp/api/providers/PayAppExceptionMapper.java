package org.revinton.payapp.api.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PayAppExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        throwable.printStackTrace(); // TODO Replace with actual logger

        // TODO add more cases when exception types are known better
        return Response.serverError()
                       .build();
    }
}
