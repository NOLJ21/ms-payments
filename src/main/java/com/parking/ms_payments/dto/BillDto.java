package com.parking.ms_payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private Long id;

    private Double total;

    private Long customerId;

    private Long employeeId;
}
