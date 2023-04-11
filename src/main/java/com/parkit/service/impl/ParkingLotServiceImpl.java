package com.parkit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkit.entity.ParkingLot;
import com.parkit.repository.ParkingLotRepository;
import com.parkit.service.ParkingLotService;

@Service
public class ParkingLotServiceImpl implements ParkingLotService
{
	@Autowired
	ParkingLotRepository parkingLotRepository;
	
	@Override
	public ParkingLot addPLot(ParkingLot plot) {
		return parkingLotRepository.save(plot);
	}

	@Override
	public ParkingLot updateTotalSlots(int plotId, int newTotalSlots) {
		// TODO Auto-generated method stub
		ParkingLot parkingLot=parkingLotRepository.findByPlotId(plotId);
		parkingLot.setTotalSlots(newTotalSlots);
		
		return parkingLotRepository.save(parkingLot);
	}


}
