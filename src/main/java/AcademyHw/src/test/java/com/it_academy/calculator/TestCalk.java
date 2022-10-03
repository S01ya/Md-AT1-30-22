package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalk {
    @ParameterizedTest
    @CsvSource(value = {"2,5,7", "-3, -1, -4", "-3, 2, -1", "0,5,5", "0.2, 0.1, 0.3"})
    void testAddOperationManyValues(double number1, double number2, double result) {
        assertEquals(result, Calculator.summ(number1, number2),3);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,5,-3", "-3, -1, -2", "-3, 2, -5", "0,5,-5", "0.2, 0.1, 0.1"})
    void testSubtractOperationManyValues(double number1, double number2, double result) {
        assertEquals(result, Calculator.subtract(number1, number2),3);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,2,4", "-3,-6,18", "-3,2,-6", "0,6,0", "0.2, 0.1,0.02"})
    void testMultiplyOperationManyValues(double number1, double number2, double result) {
        assertEquals(result, Calculator.multiply(number1, number2),3);
    }

    @ParameterizedTest

    @CsvSource(value = {"2,2,1", "-3,-6,0.5", "-3,2,-1.5", "0,6,0", "0.2, 0.1,2"})
    void testDivideOperationManyValues(double number1, double number2, double result) {
        assertEquals(result, Calculator.divide(number1, number2),3);
    }
    @Test
    public void testDivideByZero() {
        System.out.println("Division by zero test");
        Double actualResult = Calculator.divide(5,0);
        assertNull(actualResult, () -> "Деление на ноль невозможно");
    }
}
