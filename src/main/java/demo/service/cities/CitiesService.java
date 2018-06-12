package demo.service.cities;

import demo.domain.City;

import java.util.List;

public interface CitiesService {

    void add(int qunatity);
    List<City> cities();
    List<String> nameOfCities();
}
