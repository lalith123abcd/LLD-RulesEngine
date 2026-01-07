package com.lld.ruleEnginne.rules.impl;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.rules.ExpenseRule;
import com.lld.ruleEnginne.rules.Violation;

import java.util.Optional;

public class DisAllowRule implements ExpenseRule {
    @Override
    public Optional<Violation> check(Expense e) {

    }
}
