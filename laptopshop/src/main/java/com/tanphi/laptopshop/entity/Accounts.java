package com.tanphi.laptopshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="accounts")
@Data
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String username;
    private String passwords;
    private String gmail;
    private String firstname;
    private String lastname;
    private String address;
    private String phonenumber;
    private String activationCode;
    private String passwordresetCode;
    private String activeAccount;
    private String provider;
    private String roles;
}
