package demo.responce.forecast;

import demo.repositories.MockForecastWeatherInWarsaw;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastJsonObjectFromUrlTest {

    private MockForecastWeatherInWarsaw warsaw = new MockForecastWeatherInWarsaw();

    @Test
    public void responseContainCityWarsaw() throws JSONException {
        assertEquals("Warsaw", warsaw.fillStructure().getForecastCity().getNameOfCity());
    }
}