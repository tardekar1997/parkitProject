package com.parkit.service;

import com.parkit.entity.ParkingLot;

public interface ParkingLotService {

	ParkingLot addPLot(ParkingLot plot);
	ParkingLot updateTotalSlots(int plotId, int newTotalSlots);
}
