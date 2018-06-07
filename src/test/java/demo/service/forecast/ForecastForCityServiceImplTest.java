package demo.service.forecast;

import demo.repositories.MockForecastWeatherInWarsaw;
import demo.supplier.forecast.ForecastJsonObjectFromUrl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ForecastForCityServiceImplTest {

    @InjectMocks
    private ForecastForCityServiceImpl service;

    @Mock
    private ForecastJsonObjectFromUrl objectFromUrl;

    private MockForecastWeatherInWarsaw weatherInWarsaw = new MockForecastWeatherInWarsaw();
    private String warsaw = "Warsaw";

    @Before
    public void init() {
        when(objectFromUrl.getForecastForCityByNameOfCity(warsaw)).thenReturn(weatherInWarsaw.fillStructure());
    }

    @Test
    public void getNameWarsaw() {
        assertEquals(warsaw, service.getName(warsaw));
    }

    @Test
    public void GetCountryOfWarsaw() {
        assertEquals("PL", service.getCountry(warsaw));
    }

    @Test
    public void getTempInWarsaw() {
        List<Double> expected = new ArrayList<>();
        expected.add(24.42);
        assertEquals(expected, service.getTemp(warsaw));
    }

    @Test
    public void getPressureInWarsaw() {
        List<Double> expected = new ArrayList<>();
        expected.add(1009.92);
        assertEquals(expected, service.getPressure(warsaw));
    }

    @Test
    public void getHumidityInWarsaw() {
        List<Integer> expected = new ArrayList<>();
        expected.add(68);
        assertEquals(expected, service.getHumidity(warsaw));
    }

    @Test
    public void getDescriptionOfWeatherInWarsaw() {
        List<String> expected = new ArrayList<>();
        expected.add("light rain");
        assertEquals(expected, service.getWeatherDescription(warsaw));
    }

    @Test
    public void getDateOfMeasuringWeatherInWarsaw() {
        List<String> expected = new ArrayList<>();
        expected.add("Tue Jun 05 17:00:00 CEST 2018");
        assertEquals(expected, service.getDateOfMeasuring(warsaw));
    }
}