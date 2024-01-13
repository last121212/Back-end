package com.mavidev.controller;


import com.mavidev.dto.request.AddLocationDto;
import com.mavidev.repository.entity.Location;
import com.mavidev.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import static com.mavidev.constants.ApiUrls.*;

@RestController
@RequestMapping(LOCATION)
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(ADD)
    public ResponseEntity<Location> addLocation(@RequestBody @Valid AddLocationDto dto) {
        return ResponseEntity.ok(locationService.addLocation(dto));
    }
    @GetMapping(FIND_ALL)
    private ResponseEntity<Map<String,List<String>>> findAll(){
        return ResponseEntity.ok(locationService.findAllLocationJoinCity());
    }
}
