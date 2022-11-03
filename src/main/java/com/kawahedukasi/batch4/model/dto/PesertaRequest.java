package com.kawahedukasi.batch4.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PesertaRequest {
    public String name;
    public String address;
    public String role;
    public Integer batch;
    public String className;
    public String email;
    public String phoneNumber;
}
