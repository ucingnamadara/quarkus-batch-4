package com.kawahedukasi.batch4.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Entity
@Table(name = "user")
public class User extends PanacheEntityBase {

    //UUID
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @Column(name = "email")
    public String email;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    public static Optional<User> findByUsername(String username){
        return User.find("username = ?1", username).firstResultOptional();
    }

    public static void add(String username, String password, String role){
        User user = new User();
        user.username = username;
        user.password = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        user.role = role;
        user.persist();
    }
}
