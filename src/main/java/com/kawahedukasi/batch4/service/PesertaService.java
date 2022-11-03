package com.kawahedukasi.batch4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import com.kawahedukasi.batch4.model.dto.IdPesertaResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@ApplicationScoped
public class PesertaService {

    @Inject
    SpringService springService;

    public Response post(PesertaRequest request) throws JsonProcessingException {
        Peserta peserta = newPeserta(request);
        springService.sendToSpring(peserta);

        IdPesertaResponse response = new IdPesertaResponse();
        response.id = peserta.id;
        return Response.ok(response).build();
    }

    @Transactional
    public Peserta newPeserta(PesertaRequest request){
        Peserta peserta = new Peserta();
        peserta.name = request.name;
        peserta.address= request.address;
        peserta.email= request.email;
        peserta.phoneNumber= request.phoneNumber;
        peserta.role= request.role;
        peserta.className= request.className;
        peserta.batch= request.batch;


//        peserta.persist();
        Peserta.persist(peserta);

        return peserta;
    }

    public Response getById(Long id){
        Optional<Peserta> optionalPeserta = Peserta.findByIdOptional(id);
        if(optionalPeserta.isEmpty()){
            return Response.status(BAD_REQUEST).entity("PESERTA_NOT_FOUND").build();
        }

        Peserta peserta = optionalPeserta.get();
//        Map<String, Object> response = new HashMap<>();
//        response.put("name", peserta.name);
//        response.put("address", peserta.address);
//        response.put("email", peserta.email);
//        response.put("phoneNumber", peserta.phoneNumber);
//        response.put("role", peserta.role);
//        response.put("className", peserta.className);
//        response.put("batch", peserta.batch);
        return Response.ok(peserta).build();
    }

    @Transactional
    public Response put(Long id, PesertaRequest request){
        Optional<Peserta> optionalPeserta = Peserta.findByIdOptional(id);
        if(optionalPeserta.isEmpty()){
            return Response.status(BAD_REQUEST).entity("PESERTA_NOT_FOUND").build();
        }

        Peserta peserta = optionalPeserta.get();

        peserta.name = request.name;
        peserta.address= request.address;
        peserta.email= request.email;
        peserta.phoneNumber= request.phoneNumber;
        peserta.role= request.role;
        peserta.className= request.className;
        peserta.batch= request.batch;

        Peserta.persist(peserta);

        IdPesertaResponse response = new IdPesertaResponse();
        response.id = peserta.id;
        return Response.ok(response).build();
    }

    @Transactional
    public Response delete(Long id){
        Peserta.deleteById(id);

        return Response.ok(new HashMap<>()).build();
    }

    public Response get(){
        return Response.ok(Peserta.listAll()).build();
    }

    public Response getByEmail(String email){
        Optional<Peserta> optionalPeserta = Peserta.findByEmail(email);
        if(optionalPeserta.isEmpty()){
            return Response.status(BAD_REQUEST).entity("PESERTA_NOT_FOUND").build();
        }

        Peserta peserta = optionalPeserta.get();
//        Map<String, Object> response = new HashMap<>();
//        response.put("name", peserta.name);
//        response.put("address", peserta.address);
//        response.put("email", peserta.email);
//        response.put("phoneNumber", peserta.phoneNumber);
//        response.put("role", peserta.role);
//        response.put("className", peserta.className);
//        response.put("batch", peserta.batch);
        return Response.ok(peserta).build();
    }

    public Response getByPhoneNumberOrEmail(String phoneNumber, String email){
        List<Peserta> listPeserta = Peserta.findByPhoneNumberOrEmail(phoneNumber, email);

        return Response.ok(listPeserta).build();
    }
}
