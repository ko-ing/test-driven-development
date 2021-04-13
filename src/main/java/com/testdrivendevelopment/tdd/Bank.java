package com.testdrivendevelopment.tdd;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private HashMap rates = new HashMap();

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return (int) rates.get(new Pair(from, to));
    }

    void addRate(String from, String to, int rate) {
       rates.put(new Pair(from, to), rate);
    }
}
