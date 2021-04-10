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
    }

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(new Dollar(5)));
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
// 공용 equals
// 공용 times
// ------Done- Franc과 Dollar 비교하기
// 통화?
