package demo.supplier.current;

import demo.domain.current.CurrentWeatherInCity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class CurrentJsonObjectFromUrl {

    private String apiKey = "1c34360331d821624738b822ed322c4d";
    private String units = "metric";
    private String lang = "eng";
    private String url = "https://api.openweathermap.org/data/2.5/weather?q={nameOfCity}&APPID={apiKey}&units={units}&lang={lang}";

    public CurrentWeatherInCity getCurrentWeatherFromCityByNameOfCity(String nameOfCity) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("nameOfCity", nameOfCity);
        uriVariables.put("apiKey", apiKey);
        uriVariables.put("units", units);
        uriVariables.put("lang", lang);
        return restTemplate.getForObject(url, CurrentWeatherInCity.class, uriVariables);
    }

}
