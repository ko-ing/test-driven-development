package com.testdrivendevelopment.tdd;

public interface Expression {
    Money reduce(Bank bank, String to);
}
