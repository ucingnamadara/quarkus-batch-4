package com.kawahedukasi.batch4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawahedukasi.batch4.model.Peserta;
import com.kawahedukasi.batch4.model.dto.PesertaRequest;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class SpringService {
    Logger logger = LoggerFactory.getLogger(SpringService.class);

    @Inject
    @Channel("quarkus-peserta")
    Emitter<String> springEmitter;

    @Inject
    PesertaService pesertaService;

    ObjectMapper objectMapper = new ObjectMapper();

    //sent to spring
    public void sendToSpring(Peserta peserta) throws JsonProcessingException {
        springEmitter.send(objectMapper.writeValueAsString(peserta));
    }

    //receive from spring
    @Incoming("spring-peserta")
    @Blocking
    public CompletionStage<Void> addPesertaFromSpring(Message<String> message) throws JsonProcessingException {
        String body = message.getPayload();
        logger.info(body);
        PesertaRequest request = objectMapper.readValue(body, PesertaRequest.class);
        pesertaService.newPeserta(request);
        return message.ack();
    }

}
