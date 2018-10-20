package ru.marksblog.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.marksblog.entity.Company;

@MessageEndpoint
public class SimpleListener {

    @ServiceActivator(inputChannel = "simpleGateway")
    public void handler(final Company company){
        System.out.println("Comapny: "+company.getCompanyName());
    }
}
