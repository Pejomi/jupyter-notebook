package dk.pejomi.dbbackend.service;

import dk.pejomi.dbbackend.model.Country;
import dk.pejomi.dbbackend.repository.CountryRepository;
import dk.pejomi.dbbackend.util.CSVReader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public boolean existsByName(String name) {
        return countryRepository.existsByName(name);
    }

}
