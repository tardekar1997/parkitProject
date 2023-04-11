package com.parkit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.parkit.entity.Booking;
import com.parkit.entity.ParkingLot;
import com.parkit.misc.BookingRequest;
import com.parkit.repository.BookingRepository;
import com.parkit.repository.ParkingLotRepository;

@RestController
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
    ParkingLotRepository parkingLotRepository;

	@PostMapping("bookslot")
	public ResponseEntity<Object> bookslot(@RequestBody BookingRequest bookingRequest)
	{
		ParkingLot parkingLot= parkingLotRepository.findByLocation(bookingRequest.getLocation());
		if(parkingLot==null) {
			return new ResponseEntity<>("No parking lot found for location: "+ bookingRequest.getLocation(),
										HttpStatus.NOT_FOUND);
		}
		if(parkingLot.getEmptySlots()==0) {
			return new ResponseEntity<>("No empty slot available for location : "+ bookingRequest.getLocation(),
											HttpStatus.BAD_REQUEST);
		}
		Booking NewBooking= new Booking();
		NewBooking.setLocation(bookingRequest.getLocation());
		NewBooking.setBookingDate(bookingRequest.getDate());
		NewBooking.setBookingTime(bookingRequest.getTime());
		
		bookingRepository.save(NewBooking);
		
		parkingLot.setOccupiedSlots(parkingLot.getOccupiedSlots()+1);
		parkingLot.setEmptySlots(parkingLot.getTotalSlots()-parkingLot.getOccupiedSlots());
		
		parkingLotRepository.save(parkingLot);
		
		
		return new ResponseEntity<>("booking confirmed at "+ parkingLot.getLocation(), HttpStatus.OK);
		
	}
	
	
	
}
