package demo.service.current;

import demo.domain.current.CurrentWeather;
import demo.supplier.current.CurrentJsonObjectFromUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrentWeatherInCityServiceImpl implements CurrentWeatherInCityService {

    @Autowired
    private CurrentJsonObjectFromUrl jsonObject;

    @Override
    public Double getTemperatureFromCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTemp();
    }

    @Override
    public Double getMaxTemperatureFromCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTempMax();
    }

    @Override
    public Double getMinTemperatureFromCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTempMin();
    }

    @Override
    public Double getAmplitudeOfTemperatureFromCityByNameOfCity(String nameOfCity) {
        double temp_max = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTempMax();
        double temp_min = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTempMin();
        return Math.abs(temp_max - temp_min);
    }

    @Override
    public Double getPressureFromCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentPressure();
    }

    @Override
    public Double getSpeedOfWindFromCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentWind().getCurrentSpeed();
    }

    @Override
    public String getCountryOfCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentSys().getCurrentCountry();
    }

    @Override
    public String getDirectionOfWindByNameOfCity(String nameOfCity) {
        Double deg = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentWind().getCurrentDeg();
        if (deg>11.25&&deg<=33.75) {
            return "NNE north-northeast";
        }
        if (deg>33.75&&deg<=56.25) {
            return "NE northeast";
        }
        if (deg>56.25&&deg<=78.75) {
            return "ENE east-northeast";
        }
        if (deg>78.75&&deg<=101.25) {
            return "E east";
        }
        if (deg>101.25&&deg<=123.75) {
            return "ESE east-southeast";
        }
        if (deg>123.75&&deg<=146.25) {
            return "SE southeast";
        }
        if (deg>146.25&&deg<=168.75) {
            return "SSE south-southeast";
        }
        if (deg>168.75&&deg<=191.25) {
            return "S south";
        }
        if (deg>191.25&&deg<=213.75) {
            return "SSW south-southwest";
        }
        if (deg>213.75&&deg<=236.25) {
            return "SW southwest";
        }
        if (deg>236.25&&deg<=258.75) {
            return "WSW west-southwest";
        }
        if (deg>258.75&&deg<=281.25) {
            return "W west";
        }
        if (deg>281.25&&deg<=303.75) {
            return "WNW west-northwest";
        }
        if (deg>303.75&&deg<=326.25) {
            return "NW northwest";
        }
        if (deg>326.25&&deg<=348.75) {
            return "NNW north-northwest";
        } else {
            return "N north";
        }
    }

    @Override
    public String getTimeOfDataCalculationByNameOfCity(String nameOfCity) {
        Date time=new Date(((jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity)).getDateOfCalculation())*1000);
        return time.toString();
    }

    @Override
    public String getTimeOfSunriseByNameOfCity(String nameOfCity) {
        Date timeOfSunrise=new Date(((jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity)).getCurrentSys().getCurrentSunrise())*1000);
        return timeOfSunrise.toString();
    }

    @Override
    public String getTimeOfSunsetByNameOfCity(String nameOfCity) {
        Date timeOfSunset=new Date(((jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity)).getCurrentSys().getCurrentSunset())*1000);
        return timeOfSunset.toString();
    }

    @Override
    public int getBeaufortScaleByNameOfCity(String nameOfCity) {
        double knot= jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentWind().getCurrentSpeed()/0.514;
        int beaufortScale=(int) (knot+10)/6;
        return beaufortScale;
    }

    @Override
    public String getGeoLocationByNameOfCity(String nameOfCity) {
        double tmpLatDegrees=jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentCoord().getCurrentLat();
        double tmpLonDegrees=jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentCoord().getCurrentLon();
        int latDegrees=(int) tmpLatDegrees;
        int lonDegrees=(int) tmpLonDegrees;
        double tmpLatMinutes=(tmpLatDegrees-latDegrees)*60;
        double tmpLonMinutes=(tmpLonDegrees-lonDegrees)*60;
        int latMinutes=(int) tmpLatMinutes;
        int lonMinutes=(int) tmpLonMinutes;
        int latSeconds=(int) ((tmpLatMinutes-latMinutes)*60);
        int lonSeconds=(int) ((tmpLonMinutes-lonMinutes)*60);
        String location="";
        if(latDegrees<0&&lonDegrees<0){
            location="S "+Integer.toString((latDegrees-(2*latDegrees)))+"* "+Integer.toString((latMinutes-(2*latMinutes)))+"' "+Integer.toString((latSeconds-(2*latSeconds)))+"'' "+"W "+Integer.toString((lonDegrees-(2*lonDegrees)))+"* "+Integer.toString((lonMinutes-(2*lonMinutes)))+"' "+Integer.toString((lonSeconds-(2*lonSeconds)))+"''";
        }
        if(latDegrees>0&&lonDegrees>0){
            location="N "+Integer.toString(latDegrees)+"* "+Integer.toString(latMinutes)+"' "+Integer.toString(latSeconds)+"'' "+"E "+Integer.toString(lonDegrees)+"* "+Integer.toString(lonMinutes)+"' "+Integer.toString(lonSeconds)+"''";
        }
        if(latDegrees<0&&lonDegrees>0){
            location="S "+Integer.toString((latDegrees-(2*latDegrees)))+"* "+Integer.toString((latMinutes-(2*latMinutes)))+"' "+Integer.toString((latSeconds-(2*latSeconds)))+"'' "+"E "+Integer.toString(lonDegrees)+"* "+Integer.toString(lonMinutes)+"' "+Integer.toString(lonSeconds)+"''";
        }
        if(latDegrees>0&&lonDegrees<0){
            location="N "+Integer.toString(latDegrees)+"* "+Integer.toString(latMinutes)+"' "+Integer.toString(latSeconds)+"'' "+"W "+Integer.toString((lonDegrees-(2*lonDegrees)))+"* "+Integer.toString((lonMinutes-(2*lonMinutes)))+"' "+Integer.toString((lonSeconds-(2*lonSeconds)))+"''";
        }
        return location;
    }

    @Override
    public int getHumidityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentHumidity();
    }

    @Override
    public Double getWindchillTempByNameOfCity(String nameOfCity) {
        double temp = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentTemp();
        int hum = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentMain().getCurrentHumidity();
        double wind = jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentWind().getCurrentSpeed();
        double windchill=(37-((37-temp)/(0.68-0.0014*hum+(1/(1.76+1.4*Math.pow(wind,0.75))))))-0.29*temp*(1-(hum/100));
        windchill*=100;
        windchill=Math.round(windchill);
        windchill/=100;
        return windchill;
    }

    @Override
    public List<String> getWeatherDescriptionsByNameOfCity(String nameOfCity) {
        List<String> result = new ArrayList<>();
        for (CurrentWeather weather : jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getCurrentWeathers()) {
            result.add(weather.getCurrentDescription());
        }
        return result;
    }

    @Override
    public String getNameOfCityByNameOfCity(String nameOfCity) {
        return jsonObject.getCurrentWeatherFromCityByNameOfCity(nameOfCity).getNameOfCity();
    }

}
