package org.kie.kogito.flexible.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String sayHello(Hello hello) {
        System.out.println("HAIIIII " + hello.getName());
        return "OK " + hello.getName();
    }

}
