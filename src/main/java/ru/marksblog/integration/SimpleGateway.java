package ru.marksblog.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.marksblog.entity.Company;

@MessagingGateway(name = "simpleGateway",defaultRequestChannel = "simpleGateway")
public interface SimpleGateway {

    @Gateway
    void doit(Message<Company> message);
}
