package com.example.currencyconverter.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String currency;

    private Double rate;

    public Rate() {
    }

    public Rate(String currency, Double rate) {
        this.currency = currency;
        this.rate = rate;
    }
}
