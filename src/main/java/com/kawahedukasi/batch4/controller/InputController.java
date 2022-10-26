package com.kawahedukasi.batch4.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/example")
@Produces(MediaType.TEXT_PLAIN)
public class InputController {

    @GET
    public String queryParam(
            @QueryParam("input") String input,
            @QueryParam("input2") String input2){
        return "Quarkus " + input.toUpperCase() + " " + input2.toUpperCase();
    }

    @GET
    @Path("/pathParm/{input}")
    public String pathParam(@PathParam("input") String input){
        return "Quarkus, congrats you create a input path param : " + input;
    }

    @GET
    @Path("/header")
    public String header(
            @HeaderParam("name") String name,
            @HeaderParam("address") String address,
            @HeaderParam("age") Integer age){
        return "Quarkus, Nama : " + name.toUpperCase()
                + " address : " + address.toUpperCase()
                + " age : " + age;
    }

    @POST
    @Path("/body")
    @Consumes(MediaType.TEXT_PLAIN)
    public String body(String input){
        return "Quarkus : " + input;
    }

}
