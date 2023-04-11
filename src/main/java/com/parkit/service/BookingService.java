package com.parkit.service;

import com.parkit.entity.Booking;
import com.parkit.misc.BookingRequest;

public interface BookingService {

	Booking bookSlot(BookingRequest bookingRequest);
}
