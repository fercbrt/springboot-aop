package es.fercbrt.springbootaop.services.impl;

import es.fercbrt.springbootaop.services.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
