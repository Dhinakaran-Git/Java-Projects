package com.bassure.learning.spring.boot;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Webflux {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("dhina", "sam", "daniel", "moosa")).log();//it's like db call 
    }

    public Flux<String> namesFlux_Map() {
        return Flux.fromIterable(List.of("dhina", "sam", "daniel", "moosa"))
                .map(String::toUpperCase);
    }

    public Mono<String> nameMono() {
        return Mono.just("tamil").log();
    }

    public static void main(String[] args) {
        Webflux webflux = new Webflux();
        
//        webflux.namesFlux()
//                .subscribe(name -> {
//                    System.out.println("Name is: " + name);
//                });
//        System.out.println("*".repeat(100));
//        webflux.nameMono()
//                .subscribe(name -> {
//                    System.out.println("Mono Name is: " + name);
//                });
        webflux.namesFlux_Map()
                .subscribe(get -> {
                    System.out.println(get);
                });
    }

}
