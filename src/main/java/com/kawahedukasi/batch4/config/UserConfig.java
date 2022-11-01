package com.kawahedukasi.batch4.config;

import com.kawahedukasi.batch4.model.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class UserConfig {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
        User.deleteAll();
        User.add("anandadp_", "Semangat123", "admin");
        User.add("root", "root", "admin");
    }
}
