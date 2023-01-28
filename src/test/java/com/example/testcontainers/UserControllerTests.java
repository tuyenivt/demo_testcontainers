package com.example.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
public class UserControllerTests extends AbstractTest {

    @Autowired
    private UserRepository repository;

    @Test
    void all() {
        Assertions.assertEquals(3, repository.findAll().size());
    }
}
