package com.lld.ruleEnginne.registry;

import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.rules.ExpenseRule;
import com.lld.ruleEnginne.rules.impl.DisAllowRule;
import com.lld.ruleEnginne.rules.impl.MaxAmountRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleRegistry {
    public static void getExpenseRulesRegistry(){
        Map<ExpenseType, List<ExpenseRule>> registry=new HashMap<>();

        registry.put(ExpenseType.RESTAURANT,List.of(
                new DisAllowRule(),
                new MaxAmountRule(75)
                )


                );


        registry.put(ExpenseType.AIRFAFRE,List.of(
                        new DisAllowRule()
                )


        );
    }
    public static List<ExpenseRule> getAllExpenseRulesRegistry(){
        return List.of(
                new MaxAmountRule(200)
        );
    }
}
