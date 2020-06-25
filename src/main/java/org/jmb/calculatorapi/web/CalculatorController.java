package org.jmb.calculatorapi.web;

import javax.validation.Valid;

import org.jmb.calculatorapi.domain.model.OperationResponse;
import org.jmb.calculatorapi.domain.model.OperationType;
import org.jmb.calculatorapi.domain.service.OperationalCalculatorService;
import org.jmb.calculatorapi.dto.OperationDto;
import org.jmb.calculatorapi.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.TracerImpl;
import java.util.function.Function;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {

    @Autowired private OperationalCalculatorService operationalCalculatorService;
    @Autowired private TracerImpl tracer;

    private Function<OperationResponse, ResponseDto> toResponseDto =
        x -> ResponseDto.builder().result(x.getResult()).build();

    @PostMapping
    public ResponseDto performOperation(@RequestBody @Valid final OperationDto operationDto) {

        final OperationType operationType = OperationType.from(operationDto.getOperation())
            .orElseThrow(() -> new UnsupportedOperationException(String.format("Operation %s not supported",
                operationDto.getOperation())));

        final ResponseDto response = operationalCalculatorService
            .performOperation(operationDto.getParameter1(), operationDto.getParameter2(), operationType)
            .map(toResponseDto)
            .orElse(ResponseDto.builder().build());

        tracer.trace(response);
        return response;
    }
}
