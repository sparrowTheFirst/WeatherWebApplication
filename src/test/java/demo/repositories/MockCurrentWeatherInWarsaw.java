package demo.repositories;

import demo.domain.current.*;

public class MockCurrentWeatherInWarsaw {

    private CurrentWeatherInCity warsaw = new CurrentWeatherInCity();
    private CurrentMain main = new CurrentMain();
    private CurrentWind wind = new CurrentWind();
    private CurrentSys sys = new CurrentSys();
    private CurrentCoord coord = new CurrentCoord();
    private CurrentWeather weather = new CurrentWeather();

    public CurrentWeatherInCity fillStructure() {
        main.setCurrentTemp(24.0);
        main.setCurrentPressure(1017);
        main.setCurrentHumidity(88);

        wind.setCurrentSpeed(5.7);
        wind.setCurrentDeg(70);

        sys.setCurrentCountry("PL");
        sys.setCurrentSunrise(1527154606);
        sys.setCurrentSunset(1527201539);

        coord.setCurrentLat(17.3);
        coord.setCurrentLon(-62.73);

        weather.setCurrentDescription("broken clouds");

        warsaw.setCurrentMain(main);
        warsaw.setCurrentWind(wind);
        warsaw.setCurrentSys(sys);
        warsaw.setCurrentCoord(coord);
        warsaw.setCurrentWeathers(new CurrentWeather[] {weather});
        warsaw.setNameOfCity("Warsaw");
        warsaw.setDateOfCalculation(1527144900);
        return warsaw;
    }
}
