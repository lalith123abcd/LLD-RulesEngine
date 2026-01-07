package com.lld.ruleEnginne.services;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.TripRule;
import com.lld.ruleEnginne.services.rules.Violation;

import java.util.List;
import java.util.Map;

public interface RuleEngine {
    List<Violation> evaluate(

            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry,
            List<ExpenseRule> allExpenseRulesRegistry,
            List<TripRule> tripRulesRegistry

    );
}
