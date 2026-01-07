package com.lld.ruleEnginne.services.rules;

import com.lld.ruleEnginne.models.Expense;

import java.util.Optional;

public interface ExpenseRule {

    Optional<Violation> check(Expense e);
}
