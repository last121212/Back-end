package com.mavidev.service;

import com.mavidev.dto.request.AddLocationDto;
import com.mavidev.repository.ICityRepository;
import com.mavidev.repository.entity.City;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final ICityRepository repository;

    public CityService(ICityRepository repository) {
        this.repository = repository;
    }

    public City addCity(AddLocationDto dto) {
        Optional<City> city = repository.findByName(dto.getCityName().toLowerCase());
        if (city.isPresent()){
            return  city.get();
        }
        City addCity=City.builder()
                .name(dto.getCityName().toLowerCase())
                .build();
        return repository.save(addCity);

    }
}
