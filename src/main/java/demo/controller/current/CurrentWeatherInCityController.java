package demo.controller.current;

import demo.domain.current.CurrentWeatherInCity;
import demo.service.current.CurrentWeatherInCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/current")
public class CurrentWeatherInCityController {

    @Autowired
    private CurrentWeatherInCityService service;

    @GetMapping("/search")
    public String searchById(Model model) {
        model.addAttribute("weatherInCity", new CurrentWeatherInCity());
        return "current/currentSearch";
    }

    @PostMapping("/search")
    public String searchById(Model model, @ModelAttribute CurrentWeatherInCity weatherInCity, BindingResult bind) {
        if (bind.hasErrors()) {
            return "current/currentSearch";
        } else {
            model.addAttribute("name", service.getNameOfCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("temp", service.getTemperatureFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("pressure", service.getPressureFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("humidity", service.getHumidityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("amplitude", service.getAmplitudeOfTemperatureFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("speed", service.getSpeedOfWindFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("country", service.getCountryOfCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("direction", service.getDirectionOfWindByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("temp_max", service.getMaxTemperatureFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("temp_min", service.getMinTemperatureFromCityByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("date", service.getTimeOfDataCalculationByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("dateOfSunrise", service.getTimeOfSunriseByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("dateOfSunset", service.getTimeOfSunsetByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("beaufortScale", service.getBeaufortScaleByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("geoLocation", service.getGeoLocationByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("windchill", service.getWindchillTempByNameOfCity(weatherInCity.getNameOfCity()));
            model.addAttribute("description", service.getWeatherDescriptionsByNameOfCity(weatherInCity.getNameOfCity()));
        }
        return "current/currentHome";
    }
}
