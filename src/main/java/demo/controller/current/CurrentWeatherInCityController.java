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
            model.addAttribute("name", service.getName(weatherInCity.getNameOfCity()));
            model.addAttribute("temp", service.getTemperature(weatherInCity.getNameOfCity()));
            model.addAttribute("pressure", service.getPressure(weatherInCity.getNameOfCity()));
            model.addAttribute("humidity", service.getHumidity(weatherInCity.getNameOfCity()));
            model.addAttribute("speed", service.getSpeedOfWind(weatherInCity.getNameOfCity()));
            model.addAttribute("country", service.getCountry(weatherInCity.getNameOfCity()));
            model.addAttribute("direction", service.getDirectionOfWind(weatherInCity.getNameOfCity()));
            model.addAttribute("date", service.getDateOfMeasure(weatherInCity.getNameOfCity()));
            model.addAttribute("dateOfSunrise", service.getTimeOfSunrise(weatherInCity.getNameOfCity()));
            model.addAttribute("dateOfSunset", service.getTimeOfSunset(weatherInCity.getNameOfCity()));
            model.addAttribute("geoLocation", service.getGeoLocation(weatherInCity.getNameOfCity()));
            model.addAttribute("windchill", service.getWindchillTemp(weatherInCity.getNameOfCity()));
            model.addAttribute("description", service.getWeatherDescriptions(weatherInCity.getNameOfCity()));
        }
        return "current/currentHome";
    }
}
