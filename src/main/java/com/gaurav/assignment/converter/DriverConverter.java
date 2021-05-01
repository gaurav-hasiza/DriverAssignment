package com.gaurav.assignment.converter;

import com.gaurav.assignment.entity.Driver;
import com.gaurav.assignment.request.DriverDTO;

public class DriverConverter {

    public static Driver convertDTOtoEntity(DriverDTO driverDTO){
        return Driver.builder()
                .name(driverDTO.getDriver().getName())
                .phone_number(driverDTO.getDriver().getPhone_number())
                .build();
    }
}
