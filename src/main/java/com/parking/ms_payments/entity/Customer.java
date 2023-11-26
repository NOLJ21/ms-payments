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
@Table(name = "p_customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_customer_id")
    private Long id;

    @Column(name = "p_customer_deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "p_customer_person_id", referencedColumnName = "p_person_id")
    private Person person;
}
