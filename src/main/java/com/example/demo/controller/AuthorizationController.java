package com.example.demo.controller;

import com.example.demo.Authorities;
import com.example.demo.exeptions.InvalidCredentials;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;
    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(User guest) throws InvalidCredentials {
        return service.getAuthorities(guest.getName(), guest.getPassword());
    }
//    @GetMapping("/authorize")
//    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) throws InvalidCredentials {
//        return service.getAuthorities(user, password);
//    }
}
