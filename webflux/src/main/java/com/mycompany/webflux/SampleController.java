package com.mycompany.webflux;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class SampleController {

    public Mono<ServerResponse> sayHello(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .bodyValue("Hi, it's now : " + LocalDateTime.now());
    }

    @GetMapping("/")
    @ResponseBody
    public String Home() {
        return "Hi, it's now : " + LocalDateTime.now();
    }
}
