package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;
import web.service.CarService;

@Controller
public class CarController {

    @Autowired
private CarService carService;

@GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
    if(count >= 5 | count == null) {
        model.addAttribute("cars", carService.getCars(CarDaoImpl.getCarsList().size()));
    }
    model.addAttribute("cars", carService.getCars(count));
    return "cars";
}
}
