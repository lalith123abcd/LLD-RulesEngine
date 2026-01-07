package com.lld.ruleEnginne.rules;

import com.lld.ruleEnginne.models.Expense;

import java.util.Optional;

public interface ExpenseRule {

    Optional<Violation> check(Expense e);
}
