package com.aferreeira.MyMoney.domains;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Debts {

    private BigDecimal internet;
    private BigDecimal dizimo;
    private BigDecimal basics;
    private BigDecimal rental;
    private BigDecimal pass;
    private BigDecimal externalFood;
    private BigDecimal supermarket;

    public Debts(){
        this.internet = BigDecimal.ZERO;
        this.dizimo = BigDecimal.ZERO;
        this.basics = BigDecimal.ZERO;
        this.rental = BigDecimal.ZERO;
        this.pass = BigDecimal.ZERO;
        this.externalFood = BigDecimal.ZERO;
        this.supermarket = BigDecimal.ZERO;
    }

}
