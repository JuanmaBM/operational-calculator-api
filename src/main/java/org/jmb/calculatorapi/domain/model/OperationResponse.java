package org.jmb.calculatorapi.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponse {
    private Double result;
}
