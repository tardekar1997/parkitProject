package com.parkit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ParkingLot {
	
	@Id
	private int plotId;
	
	private int TotalSlots;
	private int OccupiedSlots;
	private int EmptySlots;
	private String location;

	
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}
	public int getTotalSlots() {
		return TotalSlots;
	}
	public void setTotalSlots(int totalSlots) {
		TotalSlots = totalSlots;
	}
	public int getOccupiedSlots() {
		return OccupiedSlots;
	}
	public void setOccupiedSlots(int occupiedSlots) {
		OccupiedSlots = occupiedSlots;
	}
	public int getEmptySlots() {
		return EmptySlots;
	}
	public void setEmptySlots(int emptySlots) {
		EmptySlots = emptySlots;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
	
}
