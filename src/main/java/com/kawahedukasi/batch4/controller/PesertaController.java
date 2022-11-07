package com.kawahedukasi.batch4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kawahedukasi.batch4.exception.ValidationException;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import com.kawahedukasi.batch4.service.PesertaService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/peserta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed("admin")
public class PesertaController {

    @Inject
    PesertaService pesertaService;

    @POST
    public Response post(PesertaRequest request) throws JsonProcessingException {
        return pesertaService.post(request);
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id) throws ValidationException {
        return pesertaService.getById(id);
    }

    @GET
    public Response get(){
        return pesertaService.get();
    }

    @GET
    @Path("/email/{email}")
    public Response getByEmail(@PathParam("email") String email){
        return pesertaService.getByEmail(email);
    }

    @GET
    @Path("/phoneNumberOrEmail")
    public Response getByPhoneNumberOrEmail(@QueryParam("phoneNumber") String phoneNumber,@QueryParam("email") String email){
        return pesertaService.getByPhoneNumberOrEmail(phoneNumber, email);
    }

    @PUT
    @Path("/{id}")
    public Response put(@PathParam("id") Long id, PesertaRequest request){
        return pesertaService.put(id, request);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        return pesertaService.delete(id);
    }
}
