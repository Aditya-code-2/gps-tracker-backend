package com.gpstracker.tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository
        extends JpaRepository<Location, Long> {

    Location findTopByDeviceIdOrderByIdDesc(
            String deviceId
    );

}