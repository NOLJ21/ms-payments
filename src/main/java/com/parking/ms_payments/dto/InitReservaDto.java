package com.parking.ms_payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitReservaDto {
    private String name;
    private Date fechaInicio;
    private Date fechaFin;
    private int horaInicio;
    private int horaFin;
}
