package dk.pejomi.dbbackend.service;

import dk.pejomi.dbbackend.model.City;
import dk.pejomi.dbbackend.model.Country;
import dk.pejomi.dbbackend.util.CSVReader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final CountryService countryService;
    private final CityService cityService;
    private final CSVReader csvReader;
    private CSVParser csvParser;

    public List<City> readData(String filePath) {
        csvParser = csvReader.readCSV(filePath);
        csvParser.forEach(csvRecord -> {
            Country country = addCountry(csvRecord);
            City city = addCity(csvRecord, country);
        });
        return cityService.getAllCities();
    }




    public Country addCountry(CSVRecord csvRecord) {
        String countryName = csvRecord.get("Country");
        String location = null;
        if (csvParser.getHeaderMap().containsKey("Country Location"))
            location = csvRecord.get("Country Location");

        if (!countryService.existsByName(countryName)) {
            Country country = Country.builder().name(countryName).location(location).build();
            return countryService.addCountry(country);
        } else {
            return countryService.getCountryByName(countryName);
        }
    }

    public City addCity(CSVRecord csvRecord, Country country) {
        String cityName = "";
        if (csvParser.getHeaderMap().containsKey("City Name")) {
            cityName = csvRecord.get("City Name");
        } else if (csvParser.getHeaderMap().containsKey("City")) {
            cityName = csvRecord.get("City");
        } else {
            cityName = csvRecord.get("City Short Name");
        }
        String location = csvRecord.get("City Location");

        if (!cityService.existsByName(cityName)) {
            City city = City.builder()
                    .name(cityName)
                    .location(location)
                    .country(country).build();
            return cityService.addCity(city);
        } else {
            return cityService.getCityByName(cityName);
        }
    }


}





