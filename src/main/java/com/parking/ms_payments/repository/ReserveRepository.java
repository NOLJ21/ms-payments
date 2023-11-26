package com.parking.ms_payments.repository;


import com.parking.ms_payments.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
