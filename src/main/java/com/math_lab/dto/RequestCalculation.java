package com.math_lab.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestCalculation {
    // Fix: use wrapper types + @NotNull so missing JSON fields are caught by validation (instead of defaulting to 0.0)
    @NotNull
    private Double firstNumber;

    // Fix: validate second number presence (we'll still check divide/modulo by zero in the service)
    @NotNull
    private Double secondNumber;

    // Fix: validate operation presence to avoid NullPointerException in switch(op)
    @NotNull
    private Operation operation;
}

