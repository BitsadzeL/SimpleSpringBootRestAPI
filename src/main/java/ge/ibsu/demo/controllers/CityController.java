package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<City> getAll() {
        return cityService.getAllCities();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public City getById(@PathVariable Long id) {
        // Assuming there's a method like getById in CityService
        return cityService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public City add(@RequestBody AddCity addCity) {
        // Assuming there's a method like addCity in CityService
        return cityService.addCity(addCity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public Boolean delete(@PathVariable Long id) {
        // Assuming there's a method like deleteCity in CityService
        return cityService.deleteCity(id);
    }



}
