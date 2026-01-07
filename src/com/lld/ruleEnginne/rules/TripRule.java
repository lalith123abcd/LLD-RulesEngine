package com.lld.ruleEnginne.rules;

import com.lld.ruleEnginne.models.Expense;

import java.util.List;
import java.util.Optional;

public interface TripRule {

    Optional<Violation> check(List<Expense> e);
}
