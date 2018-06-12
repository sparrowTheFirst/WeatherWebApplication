package demo.responce.current;

import demo.repositories.MockCurrentWeatherInWarsaw;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentJsonObjectFromUrlTest {

    private MockCurrentWeatherInWarsaw warsaw = new MockCurrentWeatherInWarsaw();

    @Test
    public void responseContainCityBrumaire() throws JSONException {
        assertEquals("Warsaw", warsaw.fillStructure().getNameOfCity());
    }

    //TODO test na porównanie pozostałych pól
}