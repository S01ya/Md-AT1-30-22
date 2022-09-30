package com.it_academy.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalk {
    @ParameterizedTest
    @CsvSource(value = {"2,5,7", "-3, -1, -4", "-3, 2, -1", "0,5,5", "0.2, 0.1, 0.3"})
    void testAddOperationManyValues(double number1, double number2, double result) {
        assertEquals(result, Calculator.summ(number1, number2));
    }
}
