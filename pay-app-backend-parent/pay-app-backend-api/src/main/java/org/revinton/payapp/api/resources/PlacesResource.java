package org.revinton.payapp.api.resources;

import org.revinton.payapp.persistence.repositories.PlaceRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
