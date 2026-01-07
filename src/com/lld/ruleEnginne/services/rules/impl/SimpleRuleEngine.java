package com.lld.ruleEnginne.services.rules.impl;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.services.RuleEngine;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.TripRule;
import com.lld.ruleEnginne.services.rules.Violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SimpleRuleEngine implements RuleEngine {
    @Override
    public List<Violation> evaluate(List<Expense> expenses, Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry, List<ExpenseRule> allExpenseRulesRegistry, List<TripRule> tripRulesRegistry) {

        List<Violation> violationsResult = new ArrayList<>();


        // 1. Check all expenses against all expense rules

        for(Expense expense : expenses) {
            // fetch all the rules for the expense type, if no rules are found, then we have empty list
            List<ExpenseRule> rules = expenseRulesRegistry.getOrDefault(expense.getExpenseType(), List.of());

            checkExpenseAgainstRules(expense, rules, violationsResult);
            checkExpenseAgainstRules(expense, allExpenseRulesRegistry, violationsResult);
        }


        // 2. Check all expenses against all trip rules

        for(TripRule rule : tripRulesRegistry) {
            Optional<Violation> violation = rule.check(expenses);
            if(violation.isPresent()) {
                violationsResult.add(violation.get());
            }
        }

        return violationsResult;
    }

    private void checkExpenseAgainstRules(Expense expense, List<ExpenseRule> rules, List<Violation> violationsResult) {
        for(ExpenseRule rule : rules) {
            Optional<Violation> violation = rule.check(expense);
            if(violation.isPresent()) {
                violationsResult.add(violation.get());
            }
        }
    }
}
