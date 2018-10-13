package ru.marksblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.marksblog.repository.CompanyRepository;

@Endpoint
public class CompanywController {

    private static final String NAMESPACE_URI = "http://marksblog.ru";

    private CompanyRepository countryRepository;

    @Autowired
    public CompanywController(CompanyRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompanyRequest")
    @ResponsePayload
    public GetCompanyResponse getCompany(@RequestPayload GetCompanyRequest request) {
        GetCompanyResponse response = new GetCompanyResponse();
        response.setCompany(countryRepository.getById(request.getId()));
        return response;
    }
}
