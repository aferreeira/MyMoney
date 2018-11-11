package com.aferreeira.MyMoney.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class DebtsNew {

    @Id
    private DebtsId debtsId;
    private Debts debts;

}
