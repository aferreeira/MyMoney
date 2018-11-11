package com.aferreeira.MyMoney.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DebtsByYearWithMonth {

    private String month;
    private Debts debts;
}
