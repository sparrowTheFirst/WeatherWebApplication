package demo.controller.forecast;

import demo.domain.forecast.ForecastCity;
import demo.service.forecast.ForecastForCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forecast")
public class ForecastForCityController {

    @Autowired
    private ForecastForCityService service;

    @GetMapping("/search")
    public String searchById(Model model) {
        model.addAttribute("city", new ForecastCity());
        return "forecast/forecastSearch";
    }

    @PostMapping("/search")
    public String search(Model model, @ModelAttribute ForecastCity city, BindingResult bind) {
        if (bind.hasErrors()) {
            return "forecast/forecastSearch";
        } else {
            model.addAttribute("name", service.getNameOfCity(city.getNameOfCity()));
            model.addAttribute("country", service.getCountryOfCity(city.getNameOfCity()));
            model.addAttribute("geoLocation", service.getGeoLocation(city.getNameOfCity()));
            model.addAttribute("date", service.getDateOfCalculation(city.getNameOfCity()));
            model.addAttribute("tempList", service.getTemp(city.getNameOfCity()));
            model.addAttribute("windchillList", service.getWindchillTemp(city.getNameOfCity()));
            model.addAttribute("dateOfCalcList", service.getDateOfCalculation(city.getNameOfCity()));
            model.addAttribute("speedOfWindList", service.getSpeedOfWind(city.getNameOfCity()));
            model.addAttribute("directOfWindList", service.getDirectionOfWind(city.getNameOfCity()));
            model.addAttribute("pressureList", service.getPressure(city.getNameOfCity()));
            model.addAttribute("humidityList", service.getHumidity(city.getNameOfCity()));
            model.addAttribute("description", service.getWeatherDescription(city.getNameOfCity()));
            model.addAttribute("cnt", service.getNumberOfLinesOfJsonObject(city.getNameOfCity()));
        }
        return "forecast/forecastHome";
    }
}
