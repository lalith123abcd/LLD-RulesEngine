package com.lld.ruleEnginne.services.rules.impl;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.Violation;

import java.util.Optional;

public class DisAllowRule implements ExpenseRule {
    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense type " + e.getExpenseType() + "id:" + e.getExpenseId() + " is not allowed"));
    }
}
