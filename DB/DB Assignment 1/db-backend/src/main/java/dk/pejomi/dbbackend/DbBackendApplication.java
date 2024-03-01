package dk.pejomi.dbbackend;

import dk.pejomi.dbbackend.service.CityService;
import dk.pejomi.dbbackend.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbBackendApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DbBackendApplication.class, args);

        // Get services
        DataService dataService = context.getBean(DataService.class);
        CityService cityService = context.getBean(CityService.class);

        // Read data from CSV files
        System.out.println("Reading data from CSV files");
        dataService.readData("src/main/resources/static/new_2016_reductions.csv");
        System.out.println("2016 reductions read");
        dataService.readData("src/main/resources/static/new_2017_reductions.csv");
        System.out.println("2017 reductions read");
        dataService.readData("src/main/resources/static/new_2016_emissions.csv");
        System.out.println("2016 emissions read");
        dataService.readData("src/main/resources/static/new_2017_emissions.csv");
        System.out.println("2017 emissions read");
        dataService.readData("src/main/resources/static/new_2023_report.csv");
        System.out.println("2023 report read");


        /*
        dataService.readData("src/main/resources/static/2016_-_Cities_Emissions_Reduction_Targets_20240207.csv");
        dataService.readData("src/main/resources/static/2016_-_Citywide_GHG_Emissions_20240207.csv");
        dataService.readData("src/main/resources/static/2017_-_Cities_Community_Wide_Emissions.csv");
        dataService.readData("src/main/resources/static/2017_-_Cities_Emissions_Reduction_Targets_20240207.csv");
        dataService.readData("src/main/resources/static/2023_Cities_Climate_Risk_and_Vulnerability_Assessments_20240207.csv");
        */

        // Print all cities
        cityService.getAllCities().forEach(System.out::println);
    }

}
