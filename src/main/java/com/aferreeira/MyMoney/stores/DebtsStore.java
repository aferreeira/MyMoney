package com.aferreeira.MyMoney.stores;

import com.aferreeira.MyMoney.domains.DebtsId;
import com.aferreeira.MyMoney.domains.DebtsNew;

import java.util.List;
import java.util.Optional;

public interface DebtsStore {

    void save(final DebtsNew debtsNew);

    Optional<DebtsNew> findById(final DebtsId debtsId);

    List<DebtsNew> findByDebtsIdYear(int year);

}
