package com.example.testcontainers;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class AbstractTest {
    private static MySQLContainer container = (MySQLContainer) new MySQLContainer("mysql:8.0.32")
            .withReuse(true);

    @DynamicPropertySource
    private static void setDatasource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @BeforeAll
    protected static void setup() {
        container.start();
    }
}
