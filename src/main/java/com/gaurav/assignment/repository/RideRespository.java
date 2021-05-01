package com.gaurav.assignment.repository;

import com.gaurav.assignment.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RideRespository extends JpaRepository<Ride, Long> {
//    public Optional<Ride> findById(Long Id);
    public List<Ride> findByCustomerId(Long customerId);
}
