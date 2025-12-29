package com.math_lab.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.math_lab.dto.RequestCalculation;
import com.math_lab.dto.ResponseCalculation;
import com.math_lab.service.CalculatorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalculatorController {

    // Fix: constructor injection via Lombok (@RequiredArgsConstructor) + immutable dependency
    private final CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseCalculation calculate(@Valid @RequestBody RequestCalculation requestCalculation){
        ResponseCalculation response = new ResponseCalculation();
        response.setResult(calculatorService.calculate(requestCalculation));
        return response;
    } 
}
