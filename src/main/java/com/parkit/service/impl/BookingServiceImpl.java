package com.parkit.service.impl;

import com.parkit.entity.Booking;
import com.parkit.entity.ParkingLot;
import com.parkit.entity.User;
import com.parkit.misc.BookingRequest;
import com.parkit.repository.BookingRepository;
import com.parkit.repository.ParkingLotRepository;
import com.parkit.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public Booking bookSlot(BookingRequest bookingRequest,User user) {
        ParkingLot parkingLot = parkingLotRepository.findByLocation(bookingRequest.getLocation());
        if (parkingLot == null || parkingLot.getEmptySlots() == 0) {
            return null;
        }
        Booking booking = new Booking();
        booking.setLocation(bookingRequest.getLocation());
        booking.setBookingDate(bookingRequest.getDate());
        booking.setBookingTime(bookingRequest.getTime());
        booking.setVehicleId(bookingRequest.getVehicleId());
        booking.setUser(user.getUsername());
        bookingRepository.save(booking);
        
        parkingLot.setOccupiedSlots(parkingLot.getOccupiedSlots() + 1);
        parkingLot.setEmptySlots(parkingLot.getTotalSlots() - parkingLot.getOccupiedSlots());
        parkingLotRepository.save(parkingLot);
        return booking;
    }
}
