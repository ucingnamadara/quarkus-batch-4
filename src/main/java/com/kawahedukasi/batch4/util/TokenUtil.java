package com.kawahedukasi.batch4.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.kawahedukasi.batch4.model.User;

import io.smallrye.jwt.build.Jwt;

public class TokenUtil {
    /**
     * Generate JWT token
     */
    public static String generateToken(User user) {
       return Jwt.issuer("kawahedukasi-issuer")
        .upn(user.username)
        .groups(new HashSet<>(List.of(user.role)))
        .claim("email", user.email == null ? "" : user.email)
        .claim("phoneNumber", user.phoneNumber == null? "" : user.phoneNumber)
        .sign();
    }
}