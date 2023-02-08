package com.educandoweb.course.configuration;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Larry","Larry@gmail.com","88888","1220327");
        User u2 = new User("Robert","Robertin@gmail.com","7777777","1524447");

        repository.saveAll(Arrays.asList(u1, u2));
    }
}
