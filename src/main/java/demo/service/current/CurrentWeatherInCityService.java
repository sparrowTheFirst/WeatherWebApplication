package demo.service.current;

import java.util.List;

public interface CurrentWeatherInCityService {

    String getName(String nameOfCity);
    Double getTemperature(String nameOfCity);
    Double getPressure(String nameOfCity);
    Double getSpeedOfWind(String nameOfCity);
    String getCountry(String nameOfCity);
    String getDirectionOfWind(String nameOfCity);
    String getDateOfMeasure(String nameOfCity);
    String getTimeOfSunrise(String nameOfCity);
    String getTimeOfSunset(String nameOfCity);
    String getGeoLocation(String nameOfCity);
    int getHumidity(String nameOfCity);
    Double getWindchillTemp(String nameOfCity);
    List<String> getWeatherDescriptions(String nameOfCity);
}
