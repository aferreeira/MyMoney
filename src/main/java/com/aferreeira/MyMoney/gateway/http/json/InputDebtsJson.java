package com.aferreeira.MyMoney.gateway.http.json;

import com.aferreeira.MyMoney.domains.Debts;
import com.aferreeira.MyMoney.domains.DebtsId;
import lombok.Data;

@Data
public class InputDebtsJson {

    private DebtsId debtsId;
    private Debts debts;

}
