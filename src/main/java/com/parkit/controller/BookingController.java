package com.parkit.controller;

import com.parkit.entity.Booking;
import com.parkit.misc.BookingRequest;
import com.parkit.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookslot")
    public ResponseEntity<String> bookslot(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.bookSlot(bookingRequest);
        if (booking == null) {
            return new ResponseEntity<>("No parking lot found for location: " + bookingRequest.getLocation(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Booking confirmed at " + booking.getLocation(), HttpStatus.OK);
    }
}
