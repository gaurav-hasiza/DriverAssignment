package com.gaurav.assignment.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Builder
//@RequiredArgsConstructor
public class Driver extends AbstractEntity{
    private String name;

    private String phone_number;

    private String status;

}
