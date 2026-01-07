package com.lld.ruleEnginne.services.rules.impl;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.services.rules.TripRule;
import com.lld.ruleEnginne.services.rules.Violation;
import com.lld.ruleEnginne.utils.ExpenseUtils;

import java.util.List;
import java.util.Optional;

public class TripTotalMaxRule implements TripRule {
    private final double maxAmount;

    public TripTotalMaxRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(List<Expense> expenses) {
        if(!ExpenseUtils.areAllExpensesOfSameTrip(expenses)){
            return Optional.of(Violation.of("All expenses are not from the same trip"));
        }

       double total=0;

       for(Expense e:expenses){
           total+=e.getAmountUsd();
       }
       if(total>maxAmount){
           return Optional.of(new Violation("Trip total amount exceeds the maxAmount"));

       }
        return Optional.empty();

    }
}
