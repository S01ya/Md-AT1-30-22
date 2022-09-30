package com.it_academy.calculator;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorInputServiceTest {
    @ParameterizedTest
    @CsvSource(value = {"2,2", "-3,-3", "-1,-1", "0,0", "0.3,0.3"})
    void testGetNumberValidInputManyValues(String input,  double result){
        ByteArrayInputStream inputStream = new ByteArrayInputStream((input + "\n").getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        CalculatorInputService service = new CalculatorInputService(inputStream, ps);
        assertEquals(result, service.getDouble());
    }
    @Test
    void testGetNumberInvalidInputManyValues(){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("abc\n4\n").getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        CalculatorInputService service = new CalculatorInputService(inputStream, ps);
        assertEquals(4, service.getDouble());
        String ot = byteArrayOutputStream.toString();
        assert
        assertThat(ot, contains String("Число не распознано, попробуйте еще раз"));
    }
}
