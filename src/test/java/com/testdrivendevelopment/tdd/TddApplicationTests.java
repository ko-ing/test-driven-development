package com.testdrivendevelopment.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TddApplicationTests {

    @Test
    void contextLoads() {
        testMultiplication();
    }

    @Test
    public void testMultiplication() {
        Dollar five =  new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}

//TODO:
// $5 + 10CHF = $10 (환율이 2:1일 경우)
// -DONE- $5 * 2 = $10
// amount를 private으로 만들기
// -DONE- Dollar 부작용 (side effect?)
// Money 반올림?
// -DONE- equals()
// hashCode()
// equal null
// equal object