package com.kawahedukasi.batch4.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@Produces(MediaType.TEXT_PLAIN)
public class EndpointNameController {
    @GET
    @Path("/info")
    public String info(){
        return "Kawahedukasi merupakan bootcamp java gratis";
    }

    @GET
    @Path("/address")
    public String address(){
        return "Bootcamp kawahedukasi dilakukan secara online";
    }

    @GET
    @Path("/mentor")
    public String mentor(){
        return "Kawahedukasi di mentori oleh ananda dan ridwan";
    }
}
