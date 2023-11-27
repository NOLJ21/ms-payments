package com.parking.ms_payments.service;

import com.parking.ms_payments.entity.Reserve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
@FeignClient("reserves")
public interface ReserveService {

    @GetMapping("/api/v1/reserves/{id}")
    public ResponseEntity<Reserve> getReserveById(@RequestHeader("Authorization") String token, @PathVariable Long id);
}
