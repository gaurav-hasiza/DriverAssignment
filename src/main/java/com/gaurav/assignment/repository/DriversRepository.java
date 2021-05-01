package com.gaurav.assignment.repository;

import com.gaurav.assignment.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriversRepository extends JpaRepository<Driver, Long> {
    public Optional<Driver> findById(Long Id);
}