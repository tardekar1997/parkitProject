package com.parkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkit.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {


}
