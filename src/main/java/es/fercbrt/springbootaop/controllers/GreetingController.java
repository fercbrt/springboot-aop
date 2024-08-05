package es.fercbrt.springbootaop.controllers;

import es.fercbrt.springbootaop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return ResponseEntity.ok(greetingService.sayHello(name));
    }

    @GetMapping("/exception")
    public ResponseEntity<?> exception(@RequestParam(value = "name", defaultValue = "World") String name){
        return ResponseEntity.ok(greetingService.exceptionThrower(name));
    }
}
