package com.gaurav.assignment.converter;

import com.gaurav.assignment.entity.Ride;
import com.gaurav.assignment.request.RideDTO;
import com.gaurav.assignment.request.RideStatusUpdateDTO;

public class RideConverter {

    public static Ride convertDTOtoEntity(RideDTO rideDTO){
        return Ride.builder()
                .customerId(rideDTO.getCustomerId())
                .pickupLocation(rideDTO.getPickup_location())
                .dropLocation(rideDTO.getDrop_location())
                .build();
    }
}
