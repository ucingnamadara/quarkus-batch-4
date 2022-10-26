package com.kawahedukasi.batch4.service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class BangunDatarService {
    public Response luasPersegi(Integer sisi){
        if(sisi < 1){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        Integer result = (sisi*sisi);
//        return Response.ok("Luas Persegi : " + result).build();
        return Response.status(Response.Status.OK).entity("Luas Persegi : " + result).build();
    }

    public Response kelilingPersegi(Integer sisi){
        if(sisi < 1){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Integer result = (sisi*4);
        return Response.ok("Keliling Persegi : " + result).build();
    }
}
