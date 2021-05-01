package com.gaurav.assignment.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class DriverDetailsDTO {
    @NonNull
    String name;
    @NonNull
    String phone_number;
}
