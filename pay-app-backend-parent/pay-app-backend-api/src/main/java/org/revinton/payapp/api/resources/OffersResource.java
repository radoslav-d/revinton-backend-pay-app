package org.revinton.payapp.api.resources;

import org.revinton.payapp.core.model.OfferModel;
import org.revinton.payapp.persistence.entities.Offer;
import org.revinton.payapp.persistence.repositories.OfferRepository;

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

@Path("/places/{place_uuid}/offers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OffersResource {

    @Inject
    private OfferRepository offerRepository;

    @GET
    public Response offers(@PathParam("place_uuid") UUID id) {
        return Response.ok(offerRepository.getByPlaceId(id))
                       .build();
    }

    @GET
    @Path("/{uuid}")
    public Response getById(@PathParam("place_uuid") UUID placeUuid, @PathParam("uuid") UUID id) {
        return Response.ok(offerRepository.get(id))
                                          .build();
    }

    @POST
    public Response create(@PathParam("place_uuid") UUID id, OfferModel offerModel) {
        offerModel.setId(UUID.randomUUID());
        offerModel.setPlaceId(id);
        offerRepository.insert(Offer.of(offerModel));
        return Response.ok()
                       .build();
    }
}
