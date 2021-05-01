package com.gaurav.assignment.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Builder
@Data
public class Ride extends AbstractEntity{

    private Long driverId;

    private Long customerId;

    private String Status;

    private String pickupLocation;

    private String dropLocation;

    private String fromLoc;//in KMs

    private String toLoc;

}
