package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class GreetingControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greeting() {

        var actual = client.toBlocking().retrieve(HttpRequest.GET("/greeting"));
        assertThatJson(actual).isEqualTo("{\n" +
                "name: \"micronaut\",\n" +
                "message: \"This is maicronaut service\"\n" +
                "}");
    }
}