package com.parking.ms_payments.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "p_employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_employee_id")
    private Long id;

    @Column(name = "p_employee_deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "p_employee_person_id", referencedColumnName = "p_person_id")
    private Person person;

}
