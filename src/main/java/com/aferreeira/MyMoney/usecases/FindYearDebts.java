package com.aferreeira.MyMoney.usecases;

import com.aferreeira.MyMoney.domains.DebtsByYearWithMonth;
import com.aferreeira.MyMoney.stores.DebtsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindYearDebts {

    private final DebtsStore debtsStore;

    public List<DebtsByYearWithMonth> execute(int year) {

        List<DebtsByYearWithMonth> debtsByYearWithMonths = debtsStore
                .findByDebtsIdYear(year)
                .stream()
                .map(debtsNew -> new DebtsByYearWithMonth(debtsNew.getDebtsId().getMonth(), debtsNew.getDebts()))
                .collect(Collectors.toList());

        return debtsByYearWithMonths;





//        return debtsStore
//                .findByDebtsIdYear(year)
//                .stream()
//                .map(debtsNew -> new DebtsByYearWithMonth(debtsNew.getDebtsId().getMonth(), debtsNew.getDebts()))
//                .collect(Collectors.toList());




//        final List<DebtsByYearWithMonth> debtsByYearWithMonths = new ArrayList<>();
//
//        debtsStore.findByDebtsIdYear(year).forEach(debtsNew -> {
//            debtsByYearWithMonths.add(new DebtsByYearWithMonth(debtsNew.getDebtsId().getMonth(), debtsNew.getDebts()));
//        });
//
//        return debtsByYearWithMonths;
    }
}
