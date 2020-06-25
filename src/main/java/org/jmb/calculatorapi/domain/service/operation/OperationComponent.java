package org.jmb.calculatorapi.domain.service.operation;

import org.jmb.calculatorapi.domain.model.OperationResponse;

public interface OperationComponent {
    OperationResponse calculate(Double parameter1, Double parameter2);
}
