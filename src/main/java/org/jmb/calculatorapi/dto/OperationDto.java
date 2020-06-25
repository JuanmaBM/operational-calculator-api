package org.jmb.calculatorapi.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OperationDto {
    @NotNull
    private Double parameter1;
    @NotNull
    private Double parameter2;
    @NotNull
    private String operation;
}
