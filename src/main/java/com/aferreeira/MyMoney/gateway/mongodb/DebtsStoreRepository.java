package com.aferreeira.MyMoney.gateway.mongodb;

import com.aferreeira.MyMoney.domains.DebtsId;
import com.aferreeira.MyMoney.domains.DebtsNew;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DebtsStoreRepository extends MongoRepository<DebtsNew, DebtsId> {

    List<DebtsNew> findByDebtsIdYear(int year);
}
