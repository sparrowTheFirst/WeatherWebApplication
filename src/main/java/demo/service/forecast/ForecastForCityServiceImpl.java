package demo.service.forecast;

import demo.domain.forecast.ForecastParameters;
import demo.domain.forecast.ForecastWeather;
import demo.supplier.forecast.ForecastJsonObjectFromUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastForCityServiceImpl implements ForecastForCityService {

    @Autowired
    private ForecastJsonObjectFromUrl jsonObjectFromFiveDaysForecast;


    @Override
    public String getNameOfCity(String nameOfCity) {
        return jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getNameOfCity();
    }

    @Override
    public String getCountryOfCity(String nameOfCity) {
        return jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastCity().getForecastCountry();
    }

    @Override
    public int getNumberOfLinesOfJsonObject(String nameOfCity) {
        return jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getNumOfLinesOfJson();
    }

    @Override
    public List<String> getDateOfCalculation(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getDateOfCalculation());
        }
        return result;
    }

    @Override
    public List<Double> getSpeedOfWind(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastWind().getForecastSpeed());
        }
        return result;
    }

    @Override
    public List<String> getDirectionOfWind(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            Double deg = parameter.getForecastWind().getForecastDeg();
            if (deg > 11.25 && deg <= 33.75) {
                result.add("NNE north-northeast"/*+"\n"*/);
            }
            if (deg > 33.75 && deg <= 56.25) {
                result.add("NE northeast"/*+"\n"*/);
            }
            if (deg > 56.25 && deg <= 78.75) {
                result.add("ENE east-northeast"/*+"\n"*/);
            }
            if (deg > 78.75 && deg <= 101.25) {
                result.add("E east"/*+"\n"*/);
            }
            if (deg > 101.25 && deg <= 123.75) {
                result.add("ESE east-southeast"/*+"\n"*/);
            }
            if (deg > 123.75 && deg <= 146.25) {
                result.add("SE southeast"/*+"\n"*/);
            }
            if (deg > 146.25 && deg <= 168.75) {
                result.add("SSE south-southeast"/*+"\n"*/);
            }
            if (deg > 168.75 && deg <= 191.25) {
                result.add("S south"/*+"\n"*/);
            }
            if (deg > 191.25 && deg <= 213.75) {
                result.add("SSW south-southwest"/*+"\n"*/);
            }
            if (deg > 213.75 && deg <= 236.25) {
                result.add("SW southwest"/*+"\n"*/);
            }
            if (deg > 236.25 && deg <= 258.75) {
                result.add("WSW west-southwest"/*+"\n"*/);
            }
            if (deg > 258.75 && deg <= 281.25) {
                result.add("W west"/*+"\n"*/);
            }
            if (deg > 281.25 && deg <= 303.75) {
                result.add("WNW west-northwest"/*+"\n"*/);
            }
            if (deg > 303.75 && deg <= 326.25) {
                result.add("NW northwest"/*+"\n"*/);
            }
            if (deg > 326.25 && deg <= 348.75) {
                result.add("NNW north-northwest"/*+"\n"*/);
            } else {
                result.add("N north"/*+"\n"*/);
            }
        }
        return result;
    }

    @Override
    public List<Integer> getBeaufortScale(String nameOfCity) {
        List<Integer> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            double knot = parameter.getForecastWind().getForecastSpeed() / 0.514;
            int beaufortScale = (int) (knot + 10) / 6;
            result.add(beaufortScale);
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
    public List<Double> getMaxTemp(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastMain().getForecastTempMax());
        }
        return result;
    }

    @Override
    public List<Double> getMinTemp(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            result.add(parameter.getForecastMain().getForecastTempMin());
        }
        return result;
    }

    @Override
    public Double getAmplitudeOfAllTemps(String nameOfCity) {
        double max = 0;
        double min = 0;
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            if (max < parameter.getForecastMain().getForecastTempMax()) {
                max = parameter.getForecastMain().getForecastTempMax();
            }
            if (min > parameter.getForecastMain().getForecastTempMin()) {
                min = parameter.getForecastMain().getForecastTempMin();
            }
        }
        return Math.abs(max - min);
    }

    @Override
    public List<Double> getAmplitudeOfTemp(String nameOfCity) {
        List<Double> result = new ArrayList<>();
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            double tmp = Math.abs(parameter.getForecastMain().getForecastTempMax() - parameter.getForecastMain().getForecastTempMin());
            tmp *= 100;
            tmp = Math.round(tmp);
            tmp /= 100;
            result.add(tmp);
        }
        return result;
    }

    @Override
    public Double getAverageTemp(String nameOfCity) {
        int n = 0;
        double sum = 0;
        for (ForecastParameters parameter : jsonObjectFromFiveDaysForecast.getForecastForCityByNameOfCity(nameOfCity).getForecastParameters()) {
            sum += parameter.getForecastMain().getForecastTemp();
            n++;
        }
        double result = sum / n;
        result *= 100;
        result = Math.round(result);
        result /= 100;
        return result;
    }

    @Override
    public List<Double> getAverageTempForCurrentDays(String nameOfCity) {
        List<Double> result = new ArrayList<>();

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
        String location = "";
        if (latDegrees < 0 && lonDegrees < 0) {
            location = "S " + Integer.toString((latDegrees - (2 * latDegrees))) + "* " + Integer.toString((latMinutes - (2 * latMinutes))) + "' " + Integer.toString((latSeconds - (2 * latSeconds))) + "'' " + "W " + Integer.toString((lonDegrees - (2 * lonDegrees))) + "* " + Integer.toString((lonMinutes - (2 * lonMinutes))) + "' " + Integer.toString((lonSeconds - (2 * lonSeconds))) + "''";
        }
        if (latDegrees > 0 && lonDegrees > 0) {
            location = "N " + Integer.toString(latDegrees) + "* " + Integer.toString(latMinutes) + "' " + Integer.toString(latSeconds) + "'' " + "E " + Integer.toString(lonDegrees) + "* " + Integer.toString(lonMinutes) + "' " + Integer.toString(lonSeconds) + "''";
        }
        if (latDegrees < 0 && lonDegrees > 0) {
            location = "S " + Integer.toString((latDegrees - (2 * latDegrees))) + "* " + Integer.toString((latMinutes - (2 * latMinutes))) + "' " + Integer.toString((latSeconds - (2 * latSeconds))) + "'' " + "E " + Integer.toString(lonDegrees) + "* " + Integer.toString(lonMinutes) + "' " + Integer.toString(lonSeconds) + "''";
        }
        if (latDegrees > 0 && lonDegrees < 0) {
            location = "N " + Integer.toString(latDegrees) + "* " + Integer.toString(latMinutes) + "' " + Integer.toString(latSeconds) + "'' " + "W " + Integer.toString((lonDegrees - (2 * lonDegrees))) + "* " + Integer.toString((lonMinutes - (2 * lonMinutes))) + "' " + Integer.toString((lonSeconds - (2 * lonSeconds))) + "''";
        }
        return location;
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
            windchill *= 100;
            windchill = Math.round(windchill);
            windchill /= 100;
            result.add(windchill);
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
