package com.vsu.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for printing banking operations.
 */
public class Statement {

    private final List<Operation> operations = new ArrayList<>();

    /**
     * Adds the operations to the existing history.
     * @param operation - Contains the amount, the date and the balance left after the operation.
     */
    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    /**
     * Prints the whole operation history linked to the account.
     */
    public void printOperations() {
        this.operations.forEach(this::print);
    }

    /**
     * Prints specific details linked to an operation.
     * @param operation - Contains the amount, the date and the balance left after the operation.
     */
    private void print(Operation operation) {
        String message = String.format("Your account had a movement of %.2f euros on %s." +
                        " Your current balance is : %.2f euros.",
                operation.getAmount(),
                DateUtils.convertToLocalDateViaInstant(operation.getDate()),
                operation.getBalance());
        System.out.println(message);
    }
}
