package com.parking.ms_payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

//    @lombok.Getter(onMethod_ = {@JsonProperty("p_employee_id")})
//    @lombok.Setter(onMethod_ = {@JsonProperty("p_employee_id")})
    private Long id;

//    @lombok.Getter(onMethod_ = {@JsonProperty("p_employee_person_id")})
//    @lombok.Setter(onMethod_ = {@JsonProperty("p_employee_person_id")})
    private Long person;
}
