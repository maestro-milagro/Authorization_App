package com.example.demo.repository;

import com.example.demo.Authorities;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.*;
@Repository
public class UserRepository {
    List<Authorities> rep = List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE);
    List<Authorities> nullRep = new ArrayList<>();
    Map<String, String> userPas = Map.of("user", "123", "bogdan", "321");

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userPas.containsKey(user) && userPas.containsValue(password) && userPas.get(user).equals(password)) {
            return rep;
        }
        return nullRep;
    }
}
