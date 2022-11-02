package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.dto.WilayahData;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class WilayahService {
    @Inject
    @RestClient
    WilayahClientService wilayahClientService;

    public List<WilayahData> listProvinsi(){
        return wilayahClientService.listProvinsi();
    }

    public List<WilayahData> listKota(){
        return wilayahClientService.listKota();
    }
}
