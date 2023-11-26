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
@Table(name = "p_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_user_id")
    private Long id;

    @Column(name = "p_user_username")
    private String username;

    @Column(name = "p_user_password")
    private String password;

    @Column(name = "p_user_deleted")
    private Boolean deleted;
}
