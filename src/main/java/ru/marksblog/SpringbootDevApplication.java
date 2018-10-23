package ru.marksblog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableAspectJAutoProxy
@EnableIntegration
public class SpringbootDevApplication {

   	@Value("${developer.email}")
    private String email;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDevApplication.class, args);
	}

	@GetMapping("/")
	public String main(){
	    return email;
    }
}
