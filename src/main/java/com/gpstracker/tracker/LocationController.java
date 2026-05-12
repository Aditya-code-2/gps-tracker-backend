package com.gpstracker.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationRepository repo;

    // SAVE LOCATION
    @PostMapping
    public Location saveLocation(
            @RequestBody Location location
    ) {

        return repo.save(location);

    }

    // GET LOCATION BY DEVICE ID
    @GetMapping("/{deviceId}")
    public Location getLocation(
            @PathVariable String deviceId
    ) {

        return repo.findTopByDeviceIdOrderByIdDesc(
                deviceId
        );

    }

    // TEST API
    @GetMapping("/test")
    public String test() {

        return "Backend Working Successfully";

    }

}