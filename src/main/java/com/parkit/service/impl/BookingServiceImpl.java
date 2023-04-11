package com.parkit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkit.entity.Booking;
import com.parkit.repository.BookingRepository;
import com.parkit.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Booking bookSlot(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

}
