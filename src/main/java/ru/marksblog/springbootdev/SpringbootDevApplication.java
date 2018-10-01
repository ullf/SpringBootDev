package ru.marksblog.springbootdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDevApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
        return "Hello Spring Boot!";
    }

    @GetMapping("/name/{name}")
    public String helloFrom(@PathVariable String name){
	    return "Hello from "+name+"!";
    }
}
