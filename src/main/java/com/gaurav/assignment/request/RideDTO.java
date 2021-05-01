package com.gaurav.assignment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RideDTO {
    @NonNull
    private Long customerId;
    @NonNull
    private String pickup_location;
    @NonNull
    private String drop_location;
}
