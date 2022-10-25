package com.kawahedukasi.batch4.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/http-verbs")
public class HttpVerbsController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "GET Quarkus : Ini merupakan output GET HTTP VERBS";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post(){
        return "POST Quarkus : Ini merupakan output POST HTTP VERBS";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String put(){
        return "PUT Quarkus : Ini merupakan output PUT HTTP VERBS";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(){
        return "DELETE Quarkus : Ini merupakan output DELETE HTTP VERBS";
    }

}
