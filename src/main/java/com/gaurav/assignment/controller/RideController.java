package com.gaurav.assignment.controller;

import com.gaurav.assignment.entity.Ride;
import com.gaurav.assignment.request.RideDTO;
import com.gaurav.assignment.request.RideStatusUpdateDTO;
import com.gaurav.assignment.response.ResponseBean;
import com.gaurav.assignment.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

public class RideController {
    @Autowired
    RideService rideService;

    @PostMapping( value = "/ride/new")
    public ResponseBean<Object> createRide(final @RequestBody RideDTO rideDTO) {
        final Ride ride;
        try{
            ride = rideService.save(rideDTO);
        } catch (Exception e){
            return new ResponseBean<Object>(false, "Ride creation has been failed with exception" + e.getMessage());
        }
        return new ResponseBean<Object>(true, "ride has been create with rider Id " + ride.getId(), ride);
    }

    @PostMapping( value = "/ride/{rideId}/accept-ride/driverId/{driverId}")
    public ResponseBean<Object> acceptRide(final @PathParam("rideId") Long rideId,
                             final @PathParam("driverId") Long driverId) {
        final Ride ride;
        try {
            ride = rideService.acceptRide(rideId, driverId);
        } catch (Exception e){
            return new ResponseBean<Object>(false, "failed to update the ride" + e.getMessage());
        }
        return new ResponseBean<Object>(true, String.format("ride Id %s has been accepted", ride.getId()), ride);
    }

    // driver Id will be part of token
    @PostMapping( value = "/ride/{rideId}/update-status/driver/{driverId}")
    public ResponseBean<Object> updateStatus(@PathParam("rideId") Long rideId,
                               @PathParam("rideId") Long driverId,
                               @RequestBody RideStatusUpdateDTO rideStatusUpdateDTO) {
        final Ride ride;
        try {
            ride = rideService.updateRideStatus(rideId, driverId, rideStatusUpdateDTO);
        } catch (Exception e){
            return new ResponseBean<Object>(false, "failed to update the status" + e.getMessage());
        }
        return new ResponseBean<Object>(true, String.format("ride Id %s has been accepted", ride.getId()), ride);
    }

}
