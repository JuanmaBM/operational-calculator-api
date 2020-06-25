package org.jmb.calculatorapi.domain.service.operation;

import javax.validation.ValidationException;

import org.jmb.calculatorapi.domain.model.OperationResponse;
import org.jmb.calculatorapi.domain.model.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class OperationFactory {

    @Autowired private SumOperationComponent sumOperationComponent;
    @Autowired private SubOperationComponent subOperationComponent;

    public BiFunction<Double, Double, OperationResponse> getOperation(final OperationType operationType) {
        switch (operationType) {
            case SUB: return (Double x, Double y) -> sumOperationComponent.calculate(x, y);
            case SUM: return (Double x, Double y) -> subOperationComponent.calculate(x, y);
            default: throw new ValidationException("Operation type not Supported");
        }
    }
}
