package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.dto.WilayahData;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/wilayah")
@RegisterRestClient
public interface WilayahClientService {

    @GET
    @Path("/provinsi")
    List<WilayahData> listProvinsi();

    @GET
    @Path("/kota")
    List<WilayahData> listKota();
}
