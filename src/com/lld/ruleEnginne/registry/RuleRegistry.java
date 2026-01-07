package com.lld.ruleEnginne.registry;

import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.services.rules.ExpenseRule;
import com.lld.ruleEnginne.services.rules.TripRule;
import com.lld.ruleEnginne.services.rules.impl.DisAllowRule;
import com.lld.ruleEnginne.services.rules.impl.MaxAmountRule;
import com.lld.ruleEnginne.services.rules.impl.TripTotalMaxRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleRegistry {
    public static Map<ExpenseType, List<ExpenseRule>> getExpenseRulesRegistry(){
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
        return registry;
    }
    public static List<ExpenseRule> getAllExpenseRulesRegistry(){
        return List.of(
                new MaxAmountRule(200)
        );
    }

    public static List<TripRule> getAllTripRulesRegistry() {
        return List.of(
                new TripTotalMaxRule(1000)
        );
    }
}
