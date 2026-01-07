package com.lld.ruleEnginne.services.rules.impl;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.Violation;

import java.util.Optional;

public class MaxAmountRule implements ExpenseRule {
    private final double maxAmount;

    public MaxAmountRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(Expense e) {

        if(e.getAmountUsd()>maxAmount){
            return Optional.of(Violation.of("Expense amount is greater than the amount"));
        }
        return Optional.empty();
    }
}
