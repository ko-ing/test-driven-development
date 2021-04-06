package com.testdrivendevelopment.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TddApplicationTests {

    @Test
    void contextLoads() {
    }

    public void testMultiplication() {
        Dollar five =  new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}

//TODO:
// $5 + 10CHF = $10 (환율이 2:1일 경우)
// $5 * 2 = $10