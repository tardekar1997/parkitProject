package com.parkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parkit.entity.ParkingLot;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
    ParkingLot findByLocation(String location);
    ParkingLot findByPlotId(int plotId);  

}
