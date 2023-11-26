package com.parking.ms_payments.controller;
import com.parking.ms_payments.dto.BillInfoDto;
import com.parking.ms_payments.dto.DateRangeDto;
import com.parking.ms_payments.entity.Bill;
import com.parking.ms_payments.entity.Reserve;
import com.parking.ms_payments.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/all_by_date_range")
    public ResponseEntity<List<Bill>> getAllBillsByDateRange(DateRangeDto dateRangeDto) {
        try {
            List<Bill> bills = billService.getReservesByRange(dateRangeDto);
            return ResponseEntity.ok(bills);
        } catch (Exception e) {
            log.error("Error al obtener la lista de facturas", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        try {
            Bill bill = billService.findById(id);
            return ResponseEntity.ok(bill);
        } catch (Exception e) {
            log.error("Error al obtener la factura", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveBill(@RequestBody BillInfoDto billInfoDto) {
        try {
            billService.saveBill(billInfoDto);
            return ResponseEntity.ok("Recibo guardada correctamente");
        } catch (Exception e) {
            log.error("Error al guardar la factura", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
