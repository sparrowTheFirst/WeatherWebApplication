package demo.controller;

import demo.service.cities.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CitiesController {

    @Autowired
    private CitiesService service;

    @GetMapping("/all")
    public String cityList(Model model) {
        model.addAttribute("cities", service.nameOfCities());
        return "home";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam int q) {
        service.add(q);
        model.addAttribute("cities", service.nameOfCities());
        model.addAttribute("message", "dodano nową listę");
        return "home";
    }
}
