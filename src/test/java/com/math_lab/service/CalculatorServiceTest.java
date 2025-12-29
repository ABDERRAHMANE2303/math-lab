package com.math_lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.math_lab.dto.RequestCalculation;
import com.math_lab.dto.Operation;

public class CalculatorServiceTest {


    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void shouldCalculateAllOperations() {

        assertEquals(21.0,calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.ADD)));
        assertEquals(-1.0,calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.SUBTRACT)));
        assertEquals(110.0,calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.MULTIPLY)));
        assertEquals(10.0 % 11.0,calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.MODULO)));
        assertEquals(10.0 / 11.0,calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.DIVIDE)));
        assertEquals(Math.pow(10.0, 11.0),calculatorService.calculate(new RequestCalculation(10.0, 11.0, Operation.POWER)));
    }


    @Test
    void shouldThrowExceptionWhenDividingByZero() {

        RequestCalculation request = new RequestCalculation(10.0, 0.0, Operation.DIVIDE);

        assertThrows( IllegalArgumentException.class,() -> calculatorService.calculate(request) );
    }
}
