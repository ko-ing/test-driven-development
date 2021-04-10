package com.testdrivendevelopment.tdd;

public class Franc extends Money{
    protected String currency;

    Franc(int amount, String currency) {
        super(amount, currency);
    }
}
