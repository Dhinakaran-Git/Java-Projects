package com.mycompany.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class Webflux {
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction(SampleController sc) {
        return RouterFunctions.route()
                .GET("/hello", (request) -> sc.sayHello(request))
                .build();
    }
    
    @Bean
    public RouterFunction<ServerResponse> employeeRouter(SampleController sc) {
        EmployeeHandler handler = new EmployeeHandler();
        return RouterFunctions.route()
                .GET("/new", (req) -> handler.newEmployee(req))
                .GET("/newUser", req -> {
                    Employee em = new Employee(0, "name", "email", 0);
                    return ServerResponse.ok().bodyValue(em);
                })
                .build();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Webflux.class, args);
    }
}
