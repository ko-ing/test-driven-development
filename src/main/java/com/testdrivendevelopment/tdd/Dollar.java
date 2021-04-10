package com.testdrivendevelopment.tdd;

public class Dollar extends Money{
    protected String currency;

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}
