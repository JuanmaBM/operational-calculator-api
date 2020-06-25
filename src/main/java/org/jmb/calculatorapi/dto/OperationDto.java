package org.jmb.calculatorapi.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import lombok.Data;

@Data
public class OperationDto implements Serializable {
    private static final long serialVersionUID = 6635036949565333274L;
    @NotNull
    private Double parameter1;
    @NotNull
    private Double parameter2;
    @NotNull
    private String operation;
}
