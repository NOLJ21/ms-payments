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
@Table(name = "p_person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_person_id")
    private Long id;

    @Column(name = "p_person_name")
    private String name;

    @Column(name = "p_person_surname")
    private String surname;

    @Column(name = "p_person_email")
    private String email;

    @Column(name = "p_person_phone")
    private String phone;

    @Column(name = "p_person_dni")
    private String dni;

    @Column(name = "p_person_deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "p_person_user_id", referencedColumnName = "p_user_id")
    private User user;
}
