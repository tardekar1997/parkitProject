package com.parkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.parkit.entity.ParkingLot;
import com.parkit.service.ParkingLotService;

@RestController
public class ParkingLotController {
	
	@Autowired
	ParkingLotService parkingLotService;
	
	@PostMapping("addplot")
	ResponseEntity<ParkingLot> createLot(@RequestBody ParkingLot plot){
		ParkingLot newLot= parkingLotService.addPLot(plot);
		return new ResponseEntity<>(newLot,HttpStatus.CREATED);
			}
	
	@PutMapping("updateLot/{plotId}/newTotalSlots/{newTotalSlots}")
	ResponseEntity<ParkingLot> updateTotalSlots(@PathVariable int plotId,
												@PathVariable int newTotalSlots){
		
	ParkingLot updatedLot=parkingLotService.updateTotalSlots(plotId, newTotalSlots);
		return new ResponseEntity<>(updatedLot, HttpStatus.OK);
		
	}
}
