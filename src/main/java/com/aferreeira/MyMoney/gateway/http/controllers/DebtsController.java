package com.aferreeira.MyMoney.gateway.http.controllers;

import com.aferreeira.MyMoney.domains.*;
import com.aferreeira.MyMoney.gateway.http.json.InputDebtsJson;
import com.aferreeira.MyMoney.usecases.FindMonthDebts;
import com.aferreeira.MyMoney.usecases.FindYearDebts;
import com.aferreeira.MyMoney.usecases.UpdateDebts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
public class DebtsController {

    private final UpdateDebts updateDebts;

    private final FindMonthDebts findMonthDebts;

    private final FindYearDebts findYearDebts;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/update")
    public void postEvent(@RequestBody final InputDebtsJson inputDebtsJson){
        updateDebts.execute(inputDebtsJson);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getdebts")
    public ResponseEntity<DebtsNew> debtsNew(final DebtsId debtsId){
        return ResponseEntity.ok(findMonthDebts.execute(debtsId));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/alldebtsbyyear")
    public ResponseEntity<DebtsByYear> debtsByYear(final int year){
        DebtsByYear debtsByYear = new DebtsByYear(year);
        List<DebtsByYearWithMonth> debtsByYearWithMonths = findYearDebts.execute(year);
        debtsByYear.setDebtsByYearWithMonths(debtsByYearWithMonths);
        return ResponseEntity.ok(debtsByYear);

    }
}