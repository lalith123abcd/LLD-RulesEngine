import com.lld.ruleEnginne.models.Expense;
import com.lld.ruleEnginne.models.ExpenseType;
import com.lld.ruleEnginne.registry.RuleRegistry;
import com.lld.ruleEnginne.services.rules.Violation;
import com.lld.ruleEnginne.services.rules.impl.SimpleRuleEngine;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("1", "1", 10.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("2", "1", 50.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("3", "1", 100.0, ExpenseType.RESTAURANT));

        List<Violation> violations=new SimpleRuleEngine().evaluate(expenses, RuleRegistry.getExpenseRulesRegistry(),
                RuleRegistry.getAllExpenseRulesRegistry(),RuleRegistry.getAllTripRulesRegistry());

        for(Violation violation:violations){
            System.out.println(violation.getMessage());
        }
    }
}