package demo.service.cities;

import demo.domain.City;
import demo.repositories.CitiesRepository;
import demo.utils.CitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesRepository repository;

    private CitiesMapper mapper;

    @Override
    public void add(int qunatity) {
        mapper = new CitiesMapper();
        for (int i = 0; i < qunatity; i++) {
            repository.save(mapper.getCities()[i]);
        }
    }

    @Override
    public List<City> cities() {
        return (List<City>) repository.findAll();
    }

    @Override
    public List<String> nameOfCities() {
        List<String> nameOfCities = new ArrayList<>();
        for (City city : repository.findAll()) {
            nameOfCities.add(city.getName());
        }
        return nameOfCities;
    }
}
