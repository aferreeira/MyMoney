package com.aferreeira.MyMoney.stores.impl;

import com.aferreeira.MyMoney.domains.Debts;
import com.aferreeira.MyMoney.domains.DebtsId;
import com.aferreeira.MyMoney.domains.DebtsNew;
import com.aferreeira.MyMoney.gateway.mongodb.DebtsStoreRepository;
import com.aferreeira.MyMoney.stores.DebtsStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DebtsStoreImpl implements DebtsStore {

    @Autowired
    private DebtsStoreRepository debtsStoreRepository;

    @Override
    public void save(final DebtsNew debtsNew) {
        debtsStoreRepository.save(debtsNew);
    }

    @Override
    public Optional<DebtsNew> findById(DebtsId debtsId) {
        return debtsStoreRepository.findById(debtsId);
    }

    @Override
    public List<DebtsNew> findByDebtsIdYear(int year) {
        return debtsStoreRepository.findByDebtsIdYear(year);
    }

}