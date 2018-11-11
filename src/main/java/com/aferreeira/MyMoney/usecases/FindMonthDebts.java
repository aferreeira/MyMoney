package com.aferreeira.MyMoney.usecases;

import com.aferreeira.MyMoney.domains.Debts;
import com.aferreeira.MyMoney.domains.DebtsId;
import com.aferreeira.MyMoney.domains.DebtsNew;
import com.aferreeira.MyMoney.stores.DebtsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindMonthDebts {

    private final DebtsStore debtsStore;

    public DebtsNew execute(final DebtsId debtsId) {

        return debtsStore.findById(debtsId).orElseGet(() -> new DebtsNew(debtsId, new Debts()));
    }
}