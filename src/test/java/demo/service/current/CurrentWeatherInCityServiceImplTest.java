package demo.service.current;

import demo.repositories.MockCurrentWeatherInWarsaw;
import demo.supplier.current.CurrentJsonObjectFromUrl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CurrentWeatherInCityServiceImplTest {

    @InjectMocks
    private CurrentWeatherInCityServiceImpl service;

    @Mock
    private CurrentJsonObjectFromUrl objectFromUrl;

    private MockCurrentWeatherInWarsaw weatherInWarsaw = new MockCurrentWeatherInWarsaw();
    private String warsaw = "Warsaw";

    @Before
    public void init() {
        when(objectFromUrl.getCurrentWeather(warsaw)).thenReturn(weatherInWarsaw.fillStructure());
    }

    @Test
    public void getNameWarsaw() {
        assertEquals(warsaw, service.getName(warsaw));
    }

    @Test
    public void getCountryOfWarsaw() {
        assertEquals("PL", service.getCountry(warsaw));
    }

    @Test
    public void getTempInWarsaw() {
        assertEquals(24.0, service.getTemperature(warsaw), 0.0);
    }

    @Test
    public void getPressureInWarsaw(){
        assertEquals(1017, service.getPressure(warsaw), 0);
    }

    @Test
    public void  getHumidityInWarsaw() {
        assertEquals(88, service.getHumidity(warsaw));
    }

    @Test
    public void getSpeedOfWindInWarsaw() {
        assertEquals(5.7, service.getSpeedOfWind(warsaw), 0.0);
    }

    @Test
    public void getDirectionOfWindInWarsaw() {
        assertEquals("ENE east-northeast", service.getDirectionOfWind(warsaw));
    }

    @Test
    public void getDateOfWeatherInWarsaw() {
        assertEquals("Thu May 24 08:55:00 CEST 2018", service.getDateOfMeasure(warsaw));
    }

    @Test
    public void getTimeOfSunriseInWarsaw() {
        assertEquals("Thu May 24 11:36:46 CEST 2018", service.getTimeOfSunrise(warsaw));
    }

    @Test
    public void getTimeOfSunsetInWarsaw() {
        assertEquals("Fri May 25 00:38:59 CEST 2018", service.getTimeOfSunset(warsaw));
    }
}