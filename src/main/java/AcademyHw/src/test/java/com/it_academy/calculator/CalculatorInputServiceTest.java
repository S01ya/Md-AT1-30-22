package com.it_academy.calculator;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorInputServiceTest {
    @ParameterizedTest
    @CsvSource(value = {"2,2", "-3,-3", "-1,-1", "0,0", "0.3,0.3"})
    void testGetNumberValidInputManyValues(String input, String result) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream((input.replace(".", ",") + "\n").getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        CalculatorInputService service = new CalculatorInputService(inputStream, ps);
        double actual = service.getDouble();
        double expected = Double.parseDouble(result);
        assertEquals(expected, actual);
    }

    @Test
    void testGetNumberInvalidInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("abc\n4\n").getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        CalculatorInputService service = new CalculatorInputService(inputStream, ps);
        assertEquals(4, service.getDouble());
        String ot = byteArrayOutputStream.toString();
        assert (ot.contains("Число не распознано, попробуйте еще раз"));
    }

    @ParameterizedTest
    @CsvSource(value = {"+,+", "-,-", "*,*", "/,/"})
    void testGetOperationValidInputManyValues(String input, String result) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream((input).getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        CalculatorInputService service = new CalculatorInputService(inputStream, ps);
        String actual = service.getOperation();
        assertEquals(result, actual);
    }


}


