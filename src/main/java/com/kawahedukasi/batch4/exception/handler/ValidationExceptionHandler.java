package com.kawahedukasi.batch4.exception.handler;

import com.kawahedukasi.batch4.exception.ValidationException;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
    }
}
