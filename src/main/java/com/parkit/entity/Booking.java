package com.parkit.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ("bk_id"))
	private int BkId;	
	
	@Column(name = ("booking_date"))
	private LocalDate BookingDate;
	
	@Column(name = ("booking_time"))
	private LocalTime BookingTime;
	
	private String Location;
	
	public int getBkId() {
		return BkId;
	}
	
	
	public LocalDate getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		BookingDate = bookingDate;
	}

	public LocalTime getBookingTime() {
		return BookingTime;
	}
	public void setBookingTime(LocalTime bookingTime) {
		BookingTime = bookingTime;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
}
