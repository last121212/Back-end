package com.mavidev.service;

import com.mavidev.dto.request.AddLocationDto;
import com.mavidev.exception.ErrorType;
import com.mavidev.exception.MaviDevException;
import com.mavidev.repository.ILocationRepository;
import com.mavidev.repository.entity.City;
import com.mavidev.repository.entity.Location;
import com.mavidev.repository.view.VwFindAllLocationJoinCity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationService {
    private final ILocationRepository repository;
    private final CityService cityService;

    public LocationService(ILocationRepository repository, CityService cityService) {
        this.repository = repository;
        this.cityService = cityService;
    }

    public Location addLocation(AddLocationDto dto) {
        City city = cityService.addCity(dto);
        List<Location> location = repository.findByCounty(dto.getCountyName().toLowerCase());
        if (location.size()>0) {
            for(int i =0 ;i<location.size();i++){
                if (location.get(i).getCityId() == city.getId()) {

                    throw new MaviDevException(ErrorType.COUNTRY_IS_PRESENT);
                }
            }
        }
        Location addLocation = Location.builder()
                .cityId(city.getId())
                .county(dto.getCountyName().toLowerCase())
                .build();

        return  repository.save(addLocation);

    }

    public Map<String, List<String>> findAllLocationJoinCity() {
        Map<String, List<String>> location = new HashMap<String, List<String>>();
        List<VwFindAllLocationJoinCity> locationJoinCities = repository.findAllLocationJoinCity();
        for (VwFindAllLocationJoinCity l : locationJoinCities) {
            if (location.containsKey(l.getCityName())) {
                List<String> temp = location.get(l.getCityName());
                temp.add(l.getCounty());
                location.put(l.getCityName(), temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(l.getCounty());
                location.put(l.getCityName(), temp);
            }
        }
        return location;
    }

}
