package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.service.WilayahService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/wilayah")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed("admin")
public class WilayahController {

    @Inject
    WilayahService wilayahService;

    @GET
    @Path("/provinsi")
    public Response listProvinsi(){
        return Response.ok(wilayahService.listProvinsi()).build();
    }

    @GET
    @Path("/kota")
    public Response listKota(){
        return Response.ok(wilayahService.listKota()).build();
    }
}
