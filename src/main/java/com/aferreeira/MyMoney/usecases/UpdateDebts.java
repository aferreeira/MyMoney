package com.aferreeira.MyMoney.usecases;

import com.aferreeira.MyMoney.domains.Debts;
import com.aferreeira.MyMoney.domains.DebtsId;
import com.aferreeira.MyMoney.domains.DebtsNew;
import com.aferreeira.MyMoney.gateway.http.json.InputDebtsJson;
import com.aferreeira.MyMoney.stores.DebtsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateDebts {

    private final DebtsStore debtsStore;

    public void execute(final InputDebtsJson inputDebtsJson) {

        DebtsId debtsId = inputDebtsJson.getDebtsId();
        Debts debtsReceived = inputDebtsJson.getDebts();

        DebtsNew debtsNew = debtsStore
                .findById(inputDebtsJson.getDebtsId())
                .orElseGet(() -> new DebtsNew(debtsId, new Debts()));

        Debts debtsFromDB = debtsNew.getDebts();

        debtsFromDB.setInternet(debtsFromDB.getInternet().add(debtsReceived.getInternet()));
        debtsFromDB.setDizimo(debtsFromDB.getDizimo().add(debtsReceived.getDizimo()));
        debtsFromDB.setBasics(debtsFromDB.getBasics().add(debtsReceived.getBasics()));
        debtsFromDB.setRental(debtsFromDB.getRental().add(debtsReceived.getRental()));
        debtsFromDB.setPass(debtsFromDB.getPass().add(debtsReceived.getPass()));
        debtsFromDB.setExternalFood(debtsFromDB.getExternalFood().add(debtsReceived.getExternalFood()));
        debtsFromDB.setSupermarket(debtsFromDB.getSupermarket().add(debtsReceived.getSupermarket()));

        debtsStore.save(debtsNew);
    }
}
