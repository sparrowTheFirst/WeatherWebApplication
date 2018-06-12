package demo.repositories;

import demo.domain.Wind;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WindRepository extends CrudRepository<Wind, Long> {

    @Query(value = "SELECT w.direction FROM wind w WHERE (:deg) > max_degree AND (:deg) <= min_degree", nativeQuery = true)
    String getDirection(@Param("deg") Double degree);
}
