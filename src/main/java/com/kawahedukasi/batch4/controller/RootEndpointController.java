package com.kawahedukasi.batch4.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/root/endpoint")
public class RootEndpointController {
    @GET
    @Path("/peserta")
    @Produces(MediaType.TEXT_PLAIN)
    public String peserta(){
        return "Quarkus : Peserta ada 50 orang";
    }

    @GET
    @Path("/materi")
    @Produces(MediaType.TEXT_PLAIN)
    public String materi(){
        return "Quarkus : Materi adalah spring boot & java";
    }

    @GET
    @Path("/jadwal")
    @Produces(MediaType.TEXT_PLAIN)
    public String jadwal(){
        return "Quarkus : Jadwal nya dalah senin - kamis";
    }
}