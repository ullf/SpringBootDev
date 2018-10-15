package ru.marksblog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy
public class SpringbootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDevApplication.class, args);
	}

	@GetMapping("/")
	public String main(){
	    return "main";
    }
}
