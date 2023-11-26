package com.parking.ms_payments.repository;

import com.parking.ms_payments.entity.Bill;
import com.parking.ms_payments.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query("SELECT b FROM Bill b, Reserve r WHERE b.reserve.id = r.id AND r.startDate >= :fechaInicio AND r.endDate <= :fechaFin")
    List<Bill> getReservesByRange(Date fechaInicio, Date fechaFin);

    @Query("SELECT b FROM Bill b WHERE b.id = :id")
    Bill findById(long id);
}
