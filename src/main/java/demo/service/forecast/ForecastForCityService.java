package demo.service.forecast;

import java.util.List;

public interface ForecastForCityService {

    String getNameOfCity(String nameOfCity);
    String getCountryOfCity(String nameOfCity);
    int getNumberOfLinesOfJsonObject(String nameOfCity);
    List<String> getDateOfCalculation(String nameOfCity);
    List<Double> getSpeedOfWind(String nameOfCity);
    List<String> getDirectionOfWind(String nameOfCity);
    List<Integer> getBeaufortScale(String nameOfCity);
    List<Double> getTemp(String nameOfCity);
    List<Double> getPressure(String nameOfCity);
    List<Double> getMaxTemp(String nameOfCity);
    List<Double> getMinTemp(String nameOfCity);
    Double getAmplitudeOfAllTemps(String nameOfCity);
    List<Double> getAmplitudeOfTemp(String nameOfCity);
    Double getAverageTemp(String nameOfCity);
    List<Double> getAverageTempForCurrentDays(String nameOfCity);
    String getGeoLocation(String nameOfCity);
    List<Integer> getHumidity(String nameOfCity);
    List<Double> getWindchillTemp(String nameOfCity);
    List<String> getWeatherDescription(String nameOfCity);

}
