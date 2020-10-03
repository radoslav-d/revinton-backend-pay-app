package org.revinton.payapp.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/public/ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

    @GET
    public String pong() {
        return "pong";
    }

}
