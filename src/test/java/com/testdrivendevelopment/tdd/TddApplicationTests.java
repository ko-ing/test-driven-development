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
        testSimpleAddition();
        testPlusReturnsSum();
        testReduceSum();
        testReduceMoney();
        testReduceDifferentCurrency();
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
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
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
// ------Done- $5 + $5 = $10
// $5 + $5에서 Money 반환하기
// ------Done- Bank.reduce(Money)
// ------Done- Money에 대한 통화  변환을 수행하는 Reduce
// ------Done- Reduce(Bank, String)