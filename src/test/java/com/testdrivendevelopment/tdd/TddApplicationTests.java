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

    public void testMultiplication() {
        Dollar five =  new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}

//TODO:
// $5 + 10CHF = $10 (환율이 2:1일 경우)
// -DONE- $5 * 2 = $10
// amount를 private으로 만들기
// Dollar 부작용 (side effect?)
// Money 반올림?