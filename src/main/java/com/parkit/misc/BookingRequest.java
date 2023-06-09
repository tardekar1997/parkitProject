package com.parkit.misc;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequest {
	
    private String location;
    private LocalDate date;
    private LocalTime time;
    
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
    
    
}

