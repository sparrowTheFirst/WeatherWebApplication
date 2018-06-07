package demo.service.forecast;

import demo.domain.forecast.ForecastParameters;
import demo.domain.forecast.ForecastWeather;
import demo.supplier.forecast.ForecastJsonObjectFromUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForecastForCityServiceImpl implements ForecastForCityService {

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final SimpleDateFormat timeOfTheDay = new SimpleDateFormat("dd-MM-yyyy, HH:mm");

    @Autowired
    private ForecastJsonObjectFromUrl jsonObjectFromFiveDaysForecast;


    @Override
    public String getName(String nameOfCity) {
        return jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getNameOfCity();
    }

    @Override
    public String getCountry(String nameOfCity) {
        return jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getForecastCountry();
    }

    @Override
    public List<String> getDateOfMeasuring(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            SimpleDateFormat sdfTmp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = sdfTmp.parse(parameter.getDateOfCalculation());
                result.add(timeFormat.format(date));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return result;
    }

    @Override
    public List<Double> getTemp(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastMain().getForecastTemp());
        }
        return result;
    }

    @Override
    public List<Double> getPressure(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastMain().getForecastPressure());
        }
        return result;
    }

    @Override
    public String getGeoLocation(String nameOfCity) {
        double tmpLatDegrees = jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getForecastCoord().getForecastLat();
        double tmpLonDegrees = jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getForecastCoord().getForecastLon();
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
    public List<Integer> getHumidity(String nameOfCity) {
        List<Integer> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastMain().getForecastHumidity());
        }
        return result;
    }

    @Override
    public List<Double> getWindchillTemp(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            double temp = parameter.getForecastMain().getForecastTemp();
            int hum = parameter.getForecastMain().getForecastHumidity();
            double wind = parameter.getForecastWind().getForecastSpeed();
            double windchill = (37 - ((37 - temp) / (0.68 - 0.0014 * hum + (1 / (1.76 + 1.4 * Math.pow(wind, 0.75)))))) - 0.29 * temp * (1 - (hum / 100));
            result.add(Double.valueOf(Math.round(windchill * 10)/10d));
        }
        return result;
    }

    @Override
    public List<String> getWeatherDescription(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            for (ForecastWeather forecastWeather : parameter.getForecastWeathers()) {
                result.add(forecastWeather.getForecastDescription());
            }
        }
        return result;
    }
}
