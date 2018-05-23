package demo.service.current;


import java.util.List;

public interface CurrentWeatherInCityService {

    Double getTemperatureFromCityByNameOfCity(String nameOfCity);
    Double getMaxTemperatureFromCityByNameOfCity(String nameOfCity);
    Double getMinTemperatureFromCityByNameOfCity(String nameOfCity);
    Double getAmplitudeOfTemperatureFromCityByNameOfCity(String nameOfCity);
    Double getPressureFromCityByNameOfCity(String nameOfCity);
    Double getSpeedOfWindFromCityByNameOfCity(String nameOfCity);
    String getCountryOfCityByNameOfCity(String nameOfCity);
    String getDirectionOfWindByNameOfCity(String nameOfCity);
    String getTimeOfDataCalculationByNameOfCity(String nameOfCity);
    String getTimeOfSunriseByNameOfCity(String nameOfCity);
    String getTimeOfSunsetByNameOfCity(String nameOfCity);
    int getBeaufortScaleByNameOfCity(String nameOfCity);
    String getGeoLocationByNameOfCity(String nameOfCity);
    int getHumidityByNameOfCity(String nameOfCity);
    Double getWindchillTempByNameOfCity(String nameOfCity);
    List<String> getWeatherDescriptionsByNameOfCity(String nameOfCity);
    String getNameOfCityByNameOfCity(String nameOfCity);

}
