package com.math_lab.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestCalculation {
    @NotNull
    private Double firstNumber;

    @NotNull
    private Double secondNumber;

    @NotNull
    private Operation operation;
}

