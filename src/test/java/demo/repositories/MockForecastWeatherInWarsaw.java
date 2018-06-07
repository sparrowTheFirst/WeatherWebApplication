package demo.repositories;

import demo.domain.forecast.*;

public class MockForecastWeatherInWarsaw {

    private ForecastForCity warsaw = new ForecastForCity();
    private ForecastCity city = new ForecastCity();
    private ForecastCoord coord = new ForecastCoord();
    private ForecastParameters parameters = new ForecastParameters();
    private ForecastMain main = new ForecastMain();
    private ForecastWind wind = new ForecastWind();
    private ForecastWeather weather = new ForecastWeather();

    public ForecastForCity fillStructure() {
        coord.setForecastLat(52.2319);
        coord.setForecastLon(21.0067);

        main.setForecastTemp(24.42);
        main.setForecastPressure(1009.92);
        main.setForecastHumidity(68);

        wind.setForecastSpeed(4.37);
        wind.setForecastDeg(359.001);

        weather.setForecastDescription("light rain");

        parameters.setDateOfCalculation("Tue Jun 05 17:00:00 CEST 2018");
        parameters.setForecastMain(main);
        parameters.setForecastWind(wind);
        parameters.setForecastWeathers(new ForecastWeather[]{weather});

        city.setNameOfCity("Warsaw");
        city.setForecastCountry("PL");
        city.setForecastCoord(coord);

        warsaw.setForecastCity(city);
        warsaw.setForecastParameters(new ForecastParameters[] {parameters});

        return warsaw;
    }
}
