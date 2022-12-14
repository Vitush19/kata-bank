package com.vsu.kata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Of Kata Bank Project")
class KataBankApplicationTests {

    private Account account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void prepare() {
        Statement statement = new Statement();
        account = new Account(statement);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test deposit method with an amount")
    void depositTest(){
        account.deposit(30, new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 1).getTime());
        assertEquals(30.0, account.getBalance(), "Deposit has been successful.");
    }

    @Test
    @DisplayName("Test withdrawal method with an amount")
    void withdrawalTest(){
        account.withdrawal(30, new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 1).getTime());
        assertEquals(-30.0, account.getBalance(), "Withdrawal has been successful.");
    }

    @Test
    @DisplayName("Test printing statement method with no operation history")
    void printStatementWithNoOperationMadeTest(){
        account.printStatement();
        assertEquals("", outContent.toString());
    }

    @Test
    @DisplayName("Test printing statement method with one operation on history")
    void printStatementAfterAddingOneOperationTest(){
        account.deposit(30,
                new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 1).getTime());
        account.printStatement();
        assertEquals("Your account had a movement of 30,00 euros on 2022-12-01." +
                " Your current balance is : 30,00 euros.\r\n", outContent.toString());
    }

    @Test
    @DisplayName("Test printing statement method with multiples operations on history")
    void printStatementAfterAddingMultipleOperationsTest(){
        account.deposit(30,
                new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 1).getTime());
        account.withdrawal(10,
                new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 1).getTime());
        account.printStatement();
        assertEquals("Your account had a movement of 30,00 euros on 2022-12-01." +
                " Your current balance is : 30,00 euros.\r\nYour account had a movement of -10,00 euros on 2022-12-01." +
                " Your current balance is : 20,00 euros.\r\n", outContent.toString());
    }







}
