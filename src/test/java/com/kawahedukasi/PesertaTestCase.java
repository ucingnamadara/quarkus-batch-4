package com.kawahedukasi;

import com.kawahedukasi.batch4.controller.PesertaController;
import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PesertaTestCase {

    Logger logger = LoggerFactory.getLogger(PesertaTestCase.class);

    @Inject
    PesertaController pesertaController;

    @Test
    public void post(){
        PanacheMock.mock(Peserta.class);
        PanacheMock.doNothing().when(Peserta.class).persist();

        PesertaRequest request =  new PesertaRequest();
        request.name = "Test Dummy";
        request.email = "testdummy@email.com";
        request.phoneNumber = "0899999999";
        request.address = "jl. dummy";
        request.className = "A";
        request.batch = 4;
        request.role = "BE";

//        given().body(request).contentType(ContentType.JSON).post("/peserta")
//                .then().statusCode(200);
        Response response = pesertaController.post(request);
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    public void getById(){
        Peserta responseBody = new Peserta();
        responseBody.id = -99L;
        responseBody.name = "Test Dummy";
        responseBody.email = "testdummy@email.com";
        responseBody.phoneNumber = "0899999999";
        responseBody.address = "jl. dummy";
        responseBody.className = "A";
        responseBody.batch = 4;
        responseBody.role = "BE";
        Optional<PanacheEntityBase> responseOptional = Optional.of(responseBody);

        PanacheMock.mock(Peserta.class);
        Mockito.when(Peserta.findByIdOptional(Mockito.anyLong())).thenReturn(responseOptional);

        Response response = pesertaController.getById(-99L);
        Assertions.assertEquals(200, response.getStatus());
        logger.info("body -> {}", response.getEntity());
    }

    //h2 database
}