package com.kawahedukasi.batch4.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "peserta")
public class Peserta extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "peserta_sequence", sequenceName = "peserta_sequence", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "peserta_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "address", nullable = true)
    public String address;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @Column(name = "phone_number", unique = true, nullable = false)
    public String phoneNumber;

    @Column(name = "role")
    public String role;

    @Column(name = "class_name", length = 1)
    public String className;

    @Column(name = "batch")
    public Integer batch;

    @Override
    public String toString() {
        return "Peserta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", className='" + className + '\'' +
                ", batch=" + batch +
                '}';
    }

    public static Optional<Peserta> findByEmail(String email){
        return Peserta.find("email = ?1",email).firstResultOptional();
    }

    public static Optional<Peserta> findByName(String name){
        return Peserta.find("name = ?1",name).firstResultOptional();
    }

    public static Optional<Peserta> findByPhoneNumber(String phoneNumber){
        return Peserta.find("phone_number = ?1",phoneNumber).firstResultOptional();
    }

    public static List<Peserta> findByPhoneNumberOrEmail(String phoneNumber, String email){
        return Peserta.find("phone_number = ?1 OR email = ?2",phoneNumber, email).list();
    }


}
