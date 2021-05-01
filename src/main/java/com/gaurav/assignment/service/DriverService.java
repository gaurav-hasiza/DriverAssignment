package com.gaurav.assignment.service;

import com.gaurav.assignment.converter.DriverConverter;
import com.gaurav.assignment.entity.Driver;
import com.gaurav.assignment.repository.DriversRepository;
import com.gaurav.assignment.request.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverService {
    @Autowired
    private DriversRepository driversRepository;

    public Driver save(final DriverDTO driverDTO){
        Driver driver = DriverConverter.convertDTOtoEntity(driverDTO);
        Driver registeredDriverDetails = driversRepository.save(driver);
        return registeredDriverDetails;
    }


}
