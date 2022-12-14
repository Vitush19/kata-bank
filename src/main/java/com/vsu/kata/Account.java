package com.vsu.kata;

import java.util.Date;

/**
 * Class used to represent a client account.
 */
public class Account {

    private double balance = 0.0;
    private final Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }

    /**
     * Deposit a certain amount of money on a specific date.
     * @param amount - amount of money to deposit.
     * @param date - Date of the operation.
     */
    public void deposit(double amount, Date date) {
        this.balance += amount;
        Operation operation = new Operation(amount, date, this.balance);
        statement.addOperation(operation);
    }

    /**
     * Withdraw a certain amount of money on a specific date.
     * @param amount - amount of money to deposit.
     * @param date - Date of the operation.
     */
    public void withdrawal(double amount, Date date) {
        this.balance -= amount;
        Operation operation = new Operation(negativeAmount(amount), date, this.balance);
        statement.addOperation(operation);
    }

    /**
     * Prints all operations linked to the account.
     */
    public void printStatement() {
        statement.printOperations();
    }

    /**
     * Used for printing the withdrawal in operation statement.
     * @param amount - Amount of money.
     * @return The negative value of the amount.
     */
    private double negativeAmount(double amount) {
        return amount*-1;
    }

    public double getBalance() {
        return balance;
    }
}
