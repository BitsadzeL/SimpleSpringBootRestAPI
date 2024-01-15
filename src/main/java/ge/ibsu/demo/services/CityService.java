package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.AddCity;
import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import ge.ibsu.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final AddressService addressService;

    @Autowired
    public CityService(CityRepository cityRepository, AddressService addressService) {
        this.cityRepository = cityRepository;
        this.addressService = addressService;
    }

    @Transactional
    public City addCity(AddCity addCity) {
        City city = new City();
        city.setCityName(addCity.getCityName());

        // Assuming there's a method like getByAddress in AddressService
        Address address = addressService.getByAddress(addCity.getAddress());

        if (address == null) {
            address = new Address();
            address.setAddress(addCity.getAddress());
            // Set other address properties if needed
            address = addressService.addAddress(address);
        }

        city.setAddress(address);

        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public City getById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("City NOT FOUND"));
    }

    @Transactional
    public Boolean deleteCity(Long id) {
        City city = getById(id);
        cityRepository.delete(city);
        return true;
    }
}