package demo.repositories;

import demo.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CitiesRepository extends CrudRepository<City, Long> {

}
