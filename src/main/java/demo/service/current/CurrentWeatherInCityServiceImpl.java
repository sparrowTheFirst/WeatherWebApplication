package demo.service.current;

import demo.domain.current.CurrentWeather;
import demo.service.DirectionStrategy;
import demo.supplier.current.CurrentJsonObjectFromUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrentWeatherInCityServiceImpl implements CurrentWeatherInCityService {

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final SimpleDateFormat timeOfTheDay = new SimpleDateFormat("dd-MM-yyyy, HH:mm");

    @Autowired
    private CurrentJsonObjectFromUrl jsonObject;

    @Override
    public String getName(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getNameOfCity();
    }

    @Override
    public Double getTemperature(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getCurrentMain().getCurrentTemp();
    }

    @Override
    public Double getPressure(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getCurrentMain().getCurrentPressure();
    }

    @Override
    public Double getSpeedOfWind(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getCurrentWind().getCurrentSpeed();
    }

    @Override
    public String getCountry(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getCurrentSys().getCurrentCountry();
    }

    @Override
    public String getDirectionOfWind(String nameOfCity) {
        Double deg = jsonObject.getCurrentWeather(nameOfCity).getCurrentWind().getCurrentDeg();
        return new DirectionStrategy(deg).toString();
    }

    @Override
    public String getDateOfMeasure(String nameOfCity) {
        return timeOfTheDay.format(new Date(((jsonObject.getCurrentWeather(nameOfCity)).getDateOfCalculation()) * 1000));
    }

    @Override
    public String getTimeOfSunrise(String nameOfCity) {
        return timeFormat.format(new Date(((jsonObject.getCurrentWeather(nameOfCity)).getCurrentSys().getCurrentSunrise()) * 1000));
    }

    @Override
    public String getTimeOfSunset(String nameOfCity) {
        return timeFormat.format(new Date(((jsonObject.getCurrentWeather(nameOfCity)).getCurrentSys().getCurrentSunset()) * 1000));
    }

    @Override
    public String getGeoLocation(String nameOfCity) {
        double tmpLatDegrees = jsonObject.getCurrentWeather(nameOfCity).getCurrentCoord().getCurrentLat();
        double tmpLonDegrees = jsonObject.getCurrentWeather(nameOfCity).getCurrentCoord().getCurrentLon();
        int latDegrees = (int) tmpLatDegrees;
        int lonDegrees = (int) tmpLonDegrees;
        double tmpLatMinutes = (tmpLatDegrees - latDegrees) * 60;
        double tmpLonMinutes = (tmpLonDegrees - lonDegrees) * 60;
        int latMinutes = (int) tmpLatMinutes;
        int lonMinutes = (int) tmpLonMinutes;
        int latSeconds = (int) ((tmpLatMinutes - latMinutes) * 60);
        int lonSeconds = (int) ((tmpLonMinutes - lonMinutes) * 60);
        StringBuilder location = new StringBuilder();

        if (latDegrees < 0 && lonDegrees < 0) {
            location.append("S ")
                    .append(Integer.toString((latDegrees - (2 * latDegrees)))).append("* ")
                    .append(Integer.toString((latMinutes - (2 * latMinutes)))).append("' ")
                    .append(Integer.toString((latSeconds - (2 * latSeconds)))).append("'' ")
                    .append("W ")
                    .append(Integer.toString((lonDegrees - (2 * lonDegrees)))).append("* ")
                    .append(Integer.toString((lonMinutes - (2 * lonMinutes)))).append("' ")
                    .append(Integer.toString((lonSeconds - (2 * lonSeconds)))).append("''");
        }
        if (latDegrees > 0 && lonDegrees > 0) {
            location.append("N ")
                    .append(Integer.toString(latDegrees)).append("* ")
                    .append(Integer.toString(latMinutes)).append("' ")
                    .append(Integer.toString(latSeconds)).append("'' ")
                    .append("E ")
                    .append(Integer.toString(lonDegrees)).append("* ")
                    .append(Integer.toString(lonMinutes)).append("' ")
                    .append(Integer.toString(lonSeconds)).append("''");
        }
        if (latDegrees < 0 && lonDegrees > 0) {
            location.append("S ")
                    .append(Integer.toString((latDegrees - (2 * latDegrees)))).append("* ")
                    .append(Integer.toString((latMinutes - (2 * latMinutes)))).append("' ")
                    .append(Integer.toString((latSeconds - (2 * latSeconds)))).append("'' ")
                    .append("E ")
                    .append(Integer.toString(lonDegrees)).append("* ")
                    .append(Integer.toString(lonMinutes)).append("' ")
                    .append(Integer.toString(lonSeconds)).append("''");
        }
        if (latDegrees > 0 && lonDegrees < 0) {
            location.append("N ")
                    .append(Integer.toString(latDegrees)).append("* ")
                    .append(Integer.toString(latMinutes)).append("' ")
                    .append(Integer.toString(latSeconds)).append("'' ")
                    .append("W ")
                    .append(Integer.toString((lonDegrees - (2 * lonDegrees)))).append("* ")
                    .append(Integer.toString((lonMinutes - (2 * lonMinutes)))).append("' ")
                    .append(Integer.toString((lonSeconds - (2 * lonSeconds)))).append("''");
        }
        return String.valueOf(location);
    }

    @Override
    public int getHumidity(String nameOfCity) {
        return jsonObject.getCurrentWeather(nameOfCity).getCurrentMain().getCurrentHumidity();
    }

    @Override
    public Double getWindchillTemp(String nameOfCity) {
        double temp = jsonObject.getCurrentWeather(nameOfCity).getCurrentMain().getCurrentTemp();
        int hum = jsonObject.getCurrentWeather(nameOfCity).getCurrentMain().getCurrentHumidity();
        double wind = jsonObject.getCurrentWeather(nameOfCity).getCurrentWind().getCurrentSpeed();
        double windchill = (37 - ((37 - temp) / (0.68 - 0.0014 * hum + (1 / (1.76 + 1.4 * Math.pow(wind, 0.75)))))) - 0.29 * temp * (1 - (hum / 100));
        return Double.valueOf(Math.round(windchill * 10)/10d);
    }

    @Override
    public List<String> getWeatherDescriptions(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (CurrentWeather weather : jsonObject.getCurrentWeather(nameOfCity).getCurrentWeathers()) {
            result.add(weather.getCurrentDescription());
        }
        return result;
    }


}
