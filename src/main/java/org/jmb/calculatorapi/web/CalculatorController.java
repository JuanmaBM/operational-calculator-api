package org.jmb.calculatorapi.web;

import javax.validation.Valid;

import org.jmb.calculatorapi.dto.OperationDto;
import org.jmb.calculatorapi.dto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {

    @PostMapping
    public ResponseDto performOperation(@RequestBody @Valid final OperationDto operationDto) {
        return null;
    }
}
