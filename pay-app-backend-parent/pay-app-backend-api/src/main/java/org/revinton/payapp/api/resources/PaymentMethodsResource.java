package org.revinton.payapp.api.resources;

import org.revinton.payapp.core.model.PaymentMethodModel;
import org.revinton.payapp.persistence.entities.PaymentMethod;
import org.revinton.payapp.persistence.repositories.PaymentMethodRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentMethodsResource {

    @Inject
    private PaymentMethodRepository paymentMethodRepository;

    @GET
    @Path("/payment_methods")
    public Response paymentMethods() {
        return Response.ok(paymentMethodRepository.getAll())
                       .build();
    }

    @GET
    @Path("/users/{uuid}/payment_methods")
    public Response getPaymentMethodForUser(@PathParam("uuid") UUID uuid) {
        // TODO this is not right, but for the purpose of the hackathon it is ok
        return paymentMethods();
    }

    @POST
    @Path("/payment_methods")
    public Response create(PaymentMethodModel paymentMethodModel) {
        paymentMethodModel.setId(UUID.randomUUID());
        paymentMethodRepository.insert(PaymentMethod.of(paymentMethodModel));
        return Response.ok()
                       .build();
    }
}
