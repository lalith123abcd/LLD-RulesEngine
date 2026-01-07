package com.lld.ruleEnginne.models;

public class Expense {
    private final String expenseId;

    private final String tripId;

    private final double amountUsd;
    private final ExpenseType expenseType;

    public Expense(String expenseId, String tripId, double amountUsd, ExpenseType expenseType) {
        this.expenseId = expenseId;
        this.tripId = tripId;
        this.amountUsd = amountUsd;
        this.expenseType = expenseType;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public double getAmountUsd() {
        return amountUsd;
    }

    public String getTripId() {
        return tripId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }


}
