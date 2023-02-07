package com.educandoweb.course.classResources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll()
    {
        User u = new User("Maria","maria@gmail.com","99999999","12347");
        System.out.println("Ok" + u);

        return ResponseEntity.ok().body(u);
    }

}
