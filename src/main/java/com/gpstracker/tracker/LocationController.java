package com.gpstracker.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationRepository repo;

    @PostMapping
    public Location saveLocation(
            @RequestBody Location location
    ) {

        return repo.save(location);

    }

    @GetMapping("/{deviceId}")
    public Location getLocation(
            @PathVariable String deviceId
    ) {

        return repo.findTopByDeviceIdOrderByIdDesc(
                deviceId
        );

    }

}