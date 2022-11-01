package com.kawahedukasi.batch4.service;

import com.kawahedukasi.batch4.model.User;
import com.kawahedukasi.batch4.model.dto.Login;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

//    public Response login(Login request){
//        Optional<User> optionalUser = User.findByUsername(request.username);
//        if(optionalUser.isEmpty()){
//            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("message", "USER_NOT_FOUND")).build();
//        }
//
//        User user = optionalUser.get();
//        String password =BcryptUtil.bcryptHash(request.password);
//
//        logger.info("{} {}", password, user.password);
//
//
//        if(!password.equals(user.password)){
//            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("message", "WRONG_PASSWORD")).build();
//        }
//
//        String token = Base64.getEncoder().encodeToString(
//                MessageFormat.format("%s:%s", request.username, request.password)
//                        .getBytes(StandardCharsets.UTF_8));
//
//        return Response.ok(Map.of("token", token)).build();
//
//    }
}
