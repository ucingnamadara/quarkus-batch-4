package com.kawahedukasi.batch4.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "user")
@UserDefinition
public class User extends PanacheEntityBase {

    //UUID
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Username
    @Column(name = "username")
    public String username;

    @Password
    @Column(name = "password")
    public String password;

    @Roles
    @Column(name = "role")
    public String role;

    public static Optional<User> findByUsername(String username){
        return User.find("username = ?1", username).firstResultOptional();
    }

    public static void add(String username, String password, String role){
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
    }
}
