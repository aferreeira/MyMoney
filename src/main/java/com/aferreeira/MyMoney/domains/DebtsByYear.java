package com.aferreeira.MyMoney.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DebtsByYear {

    private int year;
    private List<DebtsByYearWithMonth> debtsByYearWithMonths;

    public DebtsByYear(int year){
        this.year = year;
    }
}
