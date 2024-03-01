package dk.pejomi.dbbackend.service;

import dk.pejomi.dbbackend.model.City;
import dk.pejomi.dbbackend.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;


    public City addCity(City city) {
        return cityRepository.save(city);
    }
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    public boolean existsByName(String name) {
        return cityRepository.existsByName(name);
    }


}
