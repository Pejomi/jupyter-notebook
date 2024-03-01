package dk.pejomi.dbbackend.repository;

import dk.pejomi.dbbackend.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findByName(String name);
    boolean existsByName(String name);
}
