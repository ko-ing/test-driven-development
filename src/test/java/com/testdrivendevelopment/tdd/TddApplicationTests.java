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
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
//        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
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
// Dollar/Franc 중복
// ------DONE- 공용 equals
// 공용 times
// ------Done- Franc과 Dollar 비교하기
// 통화?
// testFrancMultiplication을 지워야할까?