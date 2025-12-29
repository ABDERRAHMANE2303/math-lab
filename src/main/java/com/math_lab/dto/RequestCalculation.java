package com.math_lab.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCalculation {
    private double firstNumber;
    private double secondNumber;
    private Operation operation;
}

enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    POWER,
    MODULO
}
