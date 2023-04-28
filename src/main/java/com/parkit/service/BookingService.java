package com.parkit.service;

import com.parkit.entity.Booking;
import com.parkit.entity.User;
import com.parkit.misc.BookingRequest;

public interface BookingService {

	Booking bookSlot(BookingRequest bookingRequest, User user);
	
}
