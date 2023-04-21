package com.mycompany.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

    public Mono<ServerResponse> newEmployee(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .bodyValue("hi object : " + new Employee(798, "Dhinakaran", "dhina@mail.com", 345467865));
    }
}
