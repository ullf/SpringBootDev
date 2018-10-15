package ru.marksblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;
import ru.marksblog.service.CompanyService;

@Endpoint
public class CompanywController {

    private static final String NAMESPACE_URI = "http://marksblog.ru";

    private CompanyService companyService;

    @Autowired
    public CompanywController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompanyRequest")
    @ResponsePayload
    public GetCompanyResponse getCompany(@RequestPayload GetCompanyRequest request) {
        GetCompanyResponse response = new GetCompanyResponse();
        response.setCompany(request.getCompany());
        return response;
    }
}
