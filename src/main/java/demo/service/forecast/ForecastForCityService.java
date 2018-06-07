package demo.service.forecast;

import java.util.List;

public interface ForecastForCityService {

    String getName(String nameOfCity);
    String getCountry(String nameOfCity);
    List<String> getDateOfMeasuring(String nameOfCity);
    List<Double> getTemp(String nameOfCity);
    List<Double> getPressure(String nameOfCity);
    String getGeoLocation(String nameOfCity);
    List<Integer> getHumidity(String nameOfCity);
    List<Double> getWindchillTemp(String nameOfCity);
    List<String> getWeatherDescription(String nameOfCity);
}
