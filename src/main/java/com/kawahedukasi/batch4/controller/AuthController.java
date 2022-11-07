package com.kawahedukasi.batch4.controller;

import com.kawahedukasi.batch4.exception.ValidationException;
import com.kawahedukasi.batch4.model.dto.Login;
import com.kawahedukasi.batch4.service.AuthService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @Path("/login")
    @POST
    @PermitAll
    public Response login(Login request) throws ValidationException {
       return authService.login(request);
    }

//    @Path("/me")
//    @GET
//    public Response me(@Context SecurityContext securityContext){
//
//    }
}
