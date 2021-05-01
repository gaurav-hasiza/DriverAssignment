package com.gaurav.assignment.service;

import com.gaurav.assignment.converter.DriverConverter;
import com.gaurav.assignment.converter.RideConverter;
import com.gaurav.assignment.entity.Driver;
import com.gaurav.assignment.entity.Ride;
import com.gaurav.assignment.repository.DriversRepository;
import com.gaurav.assignment.repository.RideRespository;
import com.gaurav.assignment.request.DriverDTO;
import com.gaurav.assignment.request.RideDTO;
import com.gaurav.assignment.request.RideStatusUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RideService {
    @Autowired
    private RideRespository rideRespository;

    public Ride save(final RideDTO rideDTO){
        final Ride ride = RideConverter.convertDTOtoEntity(rideDTO);
        ride.setStatus("DRIVER_NOT_ASSIGNED");
        final Ride registeredDriverDetails = rideRespository.save(ride);
        return registeredDriverDetails;
    }

    public Ride acceptRide(final Long rideId, final Long driverId) throws Exception {
        Optional<Ride> ride = rideRespository.findById(rideId);
        // need to add validation of driver // ghk : marker
        if (ride.isPresent()){
            ride.get().setStatus("ACCEPTED");
            ride.get().setDriverId(driverId);
        } else{
            throw new Exception("Ride Not Found");
        }

        return rideRespository.save(ride.get());
    }

    public Ride updateRideStatus(final Long rideId,
                                 final Long driverId,
                                 RideStatusUpdateDTO rideStatusUpdateDTO) throws Exception {
        Optional<Ride> ride = rideRespository.findById(rideId);
        // need to add validation of driver // ghk : marker
        if (ride.isPresent()){
            ride.get().setStatus(rideStatusUpdateDTO.getStatus());
        } else{
            throw new Exception("Ride Not Found");
        }

        return rideRespository.save(ride.get());
    }
    public List<Ride> getRides(final Long customerId){

        return rideRespository.findByCustomerId(customerId);
    }
}
