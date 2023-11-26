package com.parking.ms_payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillInfoDto {
    Long idReserve;
    String nit;
    String name;
    String date;
    String endHour;
}
