package demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.City;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class CitiesMapper {

    private City[] cities;

    public CitiesMapper() {
        run();
    }

    public City[] getCities() {
        return cities;
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URI uri = getClass().getClassLoader().getResource("city.list.json").toURI();
            cities = mapper.readValue(new File(String.valueOf(Paths.get(uri))), City[].class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
