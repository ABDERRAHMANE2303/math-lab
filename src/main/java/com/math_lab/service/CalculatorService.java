package com.math_lab.service;

import org.springframework.stereotype.Service;

import com.math_lab.dto.Operation;
import com.math_lab.dto.RequestCalculation;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Service
public class CalculatorService {
    
    public double calculate(RequestCalculation requestCalculation){

        double denominator = requestCalculation.getSecondNumber();
        Operation op = requestCalculation.getOperation();

        if (op == null) {
            throw new IllegalArgumentException("Operation must be provided");
        }

        if ((op == Operation.DIVIDE || op == Operation.MODULO) && denominator == 0) {
            throw new IllegalArgumentException("Cannot divide or modulo by zero");
        }

        double result = switch (op) {
            case ADD -> requestCalculation.getFirstNumber() + denominator;
            case SUBTRACT -> requestCalculation.getFirstNumber() - denominator;
            case MULTIPLY -> requestCalculation.getFirstNumber() * denominator;
            case DIVIDE -> requestCalculation.getFirstNumber() / denominator;
            case MODULO -> requestCalculation.getFirstNumber() % denominator;
            case POWER -> Math.pow(requestCalculation.getFirstNumber(), denominator);
            default -> throw new IllegalArgumentException("Unsupported operation: " + op);
        };

        return result;
    }
    
}
