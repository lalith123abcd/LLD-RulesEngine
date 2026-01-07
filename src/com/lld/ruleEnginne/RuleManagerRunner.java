package com.lld.ruleEnginne;

import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.registry.RuleRegistry;
import com.lld.ruleEnginne.services.RuleEngine;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.TripRule;
import com.lld.ruleEnginne.services.rules.Violation;

import java.util.List;
import java.util.Map;

public class RuleManagerRunner {
    private RuleEngine ruleEngine;

    public RuleManagerRunner(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void run(List<Expense> expenses) {
        Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry = RuleRegistry.getExpenseRulesRegistry();
        List<ExpenseRule> allExpenseRulesRegistry = RuleRegistry.getAllExpenseRulesRegistry();
        List<TripRule> tripRulesRegistry = RuleRegistry.getAllTripRulesRegistry();

        List<Violation> violations = ruleEngine.evaluate(expenses, expenseRulesRegistry, allExpenseRulesRegistry, tripRulesRegistry);

        for(Violation violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
