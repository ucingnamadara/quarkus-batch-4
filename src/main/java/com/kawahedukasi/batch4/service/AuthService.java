package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.exception.ValidationException;
import com.kawahedukasi.batch4.model.User;
import com.kawahedukasi.batch4.model.dto.Login;
import com.kawahedukasi.batch4.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    public Response login(Login request) throws ValidationException {
        Optional<User> optionalUser = User.findByUsername(request.username);
        if(optionalUser.isEmpty()){
            throw new ValidationException("USER_NOT_FOUND");
        }

        User user = optionalUser.get();
        String password =Base64.getEncoder().encodeToString(request.password.getBytes(StandardCharsets.UTF_8));;


        if(!password.equals(user.password)){
            throw new ValidationException("WRONG_PASSWORD");
        }


        return Response.ok(Map.of("token", TokenUtil.generateToken(user))).build();

    }
}
