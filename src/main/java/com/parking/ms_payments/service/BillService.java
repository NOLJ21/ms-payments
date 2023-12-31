package com.parking.ms_payments.service;

import com.parking.ms_payments.dto.BillInfoDto;
import com.parking.ms_payments.dto.DateRangeDto;
import com.parking.ms_payments.dto.DateUtil;
import com.parking.ms_payments.entity.Bill;
import com.parking.ms_payments.entity.Reserve;
import com.parking.ms_payments.repository.BillRepository;
import com.parking.ms_payments.repository.ReserveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private KeycloakService keycloakService;

    @Value("${token.resource-id}")
    private String keycloakClient;

    @Value("${token.private-key}")
    private String keycloakPrivateKey;

    public List<Bill> getReservesByRange(DateRangeDto dateRangeDto) {
        try {
            Date fechaInicio = DateUtil.toDate(DateUtil.FORMAT_DATE, dateRangeDto.getStartDate());
            Date fechaFin = DateUtil.toDate(DateUtil.FORMAT_DATE, dateRangeDto.getEndDate());

            return billRepository.getReservesByRange(fechaInicio, fechaFin);
        } catch (Exception e) {
            log.error("Error al obtener la lista de reservas por rango de fechas", e);
            return null;
        }
    }

    public Bill findById(long id) {
        try {
            return billRepository.findById(id);
        } catch (Exception e) {
            log.error("Error al obtener la factura", e);
            return null;
        }
    }

    public void saveBill(BillInfoDto billInfoDto) {
        try {
            Map<String, String> data = Map.of(
                    "grant_type", "client_credentials",
                    "client_id", keycloakClient,
                    "client_secret", keycloakPrivateKey);
            String token = "Bearer " + keycloakService.getToken(data).get("access_token");

            ResponseEntity<Reserve> reserveResponseEntity = reserveService.getReserveById(token, billInfoDto.getIdReserve());
            Reserve reserve = reserveResponseEntity.getBody();

            // convertir la fecha de inicio de la reserva a Date
            Date date = DateUtil.toDate(DateUtil.FORMAT_DATE, billInfoDto.getDate());
            int endHour = Integer.parseInt(billInfoDto.getEndHour());
            int hoursInReserve = reserve.getStartTime() - endHour;
            double total = hoursInReserve * 5.0;
            reserve.setEndDate(date);
            reserve.setEndTime(endHour);

            Bill bill = new Bill();
            bill.setNit(billInfoDto.getNit());
            bill.setName(billInfoDto.getName());
            bill.setDate(date);
            bill.setTotal(total);
            bill.setCustomer(reserve.getCustomer());
            bill.setEmployee(reserve.getEmployee());
            bill.setReserve(reserve);

            reserveRepository.save(reserve);
            billRepository.save(bill);
        } catch (Exception e) {
            log.error("Error al guardar la factura", e);
        }
    }

    public List<Reserve> getReservesByUser(Long id) {
        List<Reserve> reserves = billRepository.findAllById2(id);
        return reserves;
    }
}
