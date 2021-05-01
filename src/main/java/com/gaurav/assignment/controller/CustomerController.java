package com.gaurav.assignment.controller;

import com.gaurav.assignment.entity.Ride;
import com.gaurav.assignment.request.RideDTO;
import com.gaurav.assignment.response.ResponseBean;
import com.gaurav.assignment.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    RideService rideService;

    @GetMapping( value = "/customerId/{customerId}/rides")
    public ResponseBean<Object> getRide(final @PathParam("customerId") Long customerId) {

        try{
            List<Ride> rides = rideService.getRides(customerId);
            return new ResponseBean<Object>(true, "ride has been create with rider Id" , rides);
        } catch (Exception e){
            return new ResponseBean<Object>(false, "Ride creation has been failed with exception" + e.getMessage());
        }

    }
}
