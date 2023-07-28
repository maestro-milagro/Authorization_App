package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.testcontainers.containers.GenericContainer;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8085);
    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8086);

    @BeforeAll
    static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> entityFromDev = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8085)+"/authorize?user=&password=123", String.class);
        ResponseEntity<String> entityFromProd = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8086)+"/authorize?user=user1&password=", String.class);

//        List<Authorities> expectedDev = List.of(Authorities.WRITE,Authorities.READ, Authorities.DELETE);
        String expectedProd = "User name or password is empty";
//
        Assertions.assertEquals(expectedProd, entityFromProd.getBody());
        Assertions.assertEquals(expectedProd, entityFromDev.getBody());
    }
}
