package demo.supplier.current;

import demo.ConvertJson;
import demo.repositories.MockCurrentWeatherInWarsaw;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class CurrentJsonObjectFromUrlTest {

    private MockCurrentWeatherInWarsaw warsaw = new MockCurrentWeatherInWarsaw();

    @Test
    public void responseContainCityBrumaire() throws JSONException {
        assertEquals("Warsaw", warsaw.fillStructure().getNameOfCity());
    }
}