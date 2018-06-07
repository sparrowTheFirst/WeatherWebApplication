package demo.controller.current;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class CurrentWeatherInCityControllerTest {

    @InjectMocks
    private CurrentWeatherInCityController controller;

    private MockMvc mvc;

    @Before
    public void init(){
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getSearchingPageForCurrentWeather() throws Exception {
        mvc.perform(get("/current/search"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("current/currentSearch"));
    }
}
