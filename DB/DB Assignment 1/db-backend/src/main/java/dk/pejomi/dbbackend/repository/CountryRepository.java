package dk.pejomi.dbbackend.repository;

import dk.pejomi.dbbackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findByName(String name);
    boolean existsByName(String name);
}
