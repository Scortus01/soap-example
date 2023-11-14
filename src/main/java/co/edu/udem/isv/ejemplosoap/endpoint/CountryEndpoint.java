package co.edu.udem.isv.ejemplosoap.endpoint;

import co.edu.udem.isv.ejemplo_soap.*;
import co.edu.udem.isv.ejemplosoap.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://udem.edu.co/isv/ejemplo-soap";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
    @ResponsePayload
    public CreateCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {
        CreateCountryResponse response = new CreateCountryResponse();
        response.setStatus(countryRepository.createCountry(request.getCountry()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCountriesRequest")
    @ResponsePayload
    public ListCountriesResponse listCountries() {
        ListCountriesResponse response = new ListCountriesResponse();
        List<Country> countries = countryRepository.getCountries();
        CountryList countryList = new CountryList();
        countryList.getCountry().addAll(countries);
        response.setCountries(countryList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
    @ResponsePayload
    public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {
        DeleteCountryResponse response = new DeleteCountryResponse();
        response.setStatus(countryRepository.deleteCountry(request.getName()));
        return response;
    }
}
