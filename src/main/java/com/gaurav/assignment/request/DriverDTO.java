package com.gaurav.assignment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class DriverDTO {
    @NonNull DriverDetailsDTO driver;
}
