package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.Peserta;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class PesertaService {

    @Transactional
    public Response post(String name, String address, String email,
                         String phoneNumber, String role, String className, Integer batch){
        Peserta peserta = new Peserta();
        peserta.name =name;
        peserta.address=address;
        peserta.email=email;
        peserta.phoneNumber=phoneNumber;
        peserta.role=role;
        peserta.className=className;
        peserta.batch=batch;

//        peserta.persist();
        Peserta.persist(peserta);

        return Response.ok("id : " + peserta.id).build();
    }

    public Response getById(Long id){
        Optional<Peserta> optionalPeserta = Peserta.findByIdOptional(id);
        if(optionalPeserta.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).entity("PESERTA_NOT_FOUND").build();
        }

        Peserta peserta = optionalPeserta.get();
        return Response.ok(peserta.toString()).build();
    }
}
