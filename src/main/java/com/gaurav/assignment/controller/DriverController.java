package com.gaurav.assignment.controller;

import com.gaurav.assignment.entity.Driver;
import com.gaurav.assignment.request.DriverDTO;
import com.gaurav.assignment.response.ResponseBean;
import com.gaurav.assignment.service.DriverService;
//import com.gaurav.assignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping( value = "/drivers/new")
    public ResponseBean<Object> registerDriver(@RequestBody DriverDTO driverDTO) {
        Driver driver;
        try{
            driver = driverService.save(driverDTO);
        } catch (Exception e){
            return new ResponseBean<Object>(false, "registering driver has been failed " + e.getMessage());
        }
        return new ResponseBean<Object>(true, "driver has been registered with driverId " + driver.getId(), driver);
    }

    /**
     * TODO
     * @param driverId
     * @return
     */
    @GetMapping( value = "/driver/{driverId}/rides")
    public String updateStatus(@PathParam("driverId") Long driverId) {

        return "OK";
    }


}
