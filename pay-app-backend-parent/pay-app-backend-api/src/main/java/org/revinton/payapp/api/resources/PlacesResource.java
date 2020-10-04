package org.revinton.payapp.api.resources;

import org.revinton.payapp.core.model.PlaceModel;
import org.revinton.payapp.persistence.entities.Place;
import org.revinton.payapp.persistence.repositories.PlaceRepository;

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

@Path("/places")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlacesResource {

    @Inject
    private PlaceRepository placeRepository;

    @GET
    public Response places() {
        return Response.ok(placeRepository.getAll())
                       .build();
    }

    @GET
    @Path("/{uuid}")
    public Response getById(@PathParam("uuid") UUID id) {
        return Response.ok(placeRepository.get(id))
                       .build();
    }

    @POST
    public Response create(PlaceModel placeModel) {
        placeModel.setId(UUID.randomUUID());
        placeRepository.insert(Place.of(placeModel));
        return Response.ok()
                       .build();
    }
}
