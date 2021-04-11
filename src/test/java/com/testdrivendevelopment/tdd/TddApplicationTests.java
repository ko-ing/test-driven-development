package com.testdrivendevelopment.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TddApplicationTests {

    @Test
    void contextLoads() {
        testMultiplication();
        testFrancMultiplication();
        testEquality();
        testCurrency();
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), sum);

        Money five = Money.dollar(5);
        Expression sum1 = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum1, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}

//TODO:
// $5 + 10CHF = $10 (환율이 2:1일 경우)
// ------DONE- $5 * 2 = $10
// ------DONE- amount를 private으로 만들기
// ------DONE- Dollar 부작용 (side effect?)
// Money 반올림?
// ------DONE- equals()
// hashCode()
// equal null
// equal object
// ------DONE- 5CHF * 2 = 10 CHF
// ------DONE- Dollar/Franc 중복
// ------DONE- 공용 equals
// ------DONE- 공용 times
// ------Done- Franc과 Dollar 비교하기
// ------Done- 통화?
// ------Done- testFrancMultiplication을 지워야할까?

//TODO: ------------------정리한 리스트---------------------
// $5 + 10CHF = $10 (환율이 2:1일 경우)
// $5 + $5 = $10
