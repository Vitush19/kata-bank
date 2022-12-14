package com.vsu.kata;

import java.util.Date;

/**
 * Class for storing details regarding the operations.
 */
public class Operation {

    private final double amount;
    private final Date date;
    private final double balance;

    public Operation(double amount, Date date, double balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

}
