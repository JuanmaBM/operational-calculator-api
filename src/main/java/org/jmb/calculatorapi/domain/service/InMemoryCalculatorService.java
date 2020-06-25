package org.jmb.calculatorapi.domain.service;

import org.jmb.calculatorapi.domain.model.OperationResponse;
import org.jmb.calculatorapi.domain.model.OperationType;
import org.jmb.calculatorapi.domain.service.operation.OperationFactory;
import org.jmb.calculatorapi.domain.service.operation.SubOperationComponent;
import org.jmb.calculatorapi.domain.service.operation.SumOperationComponent;
import org.jmb.calculatorapi.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@Service
public class InMemoryCalculatorService implements OperationalCalculatorService {

    @Autowired private OperationFactory operationFactory;

    @Override
    public OperationResponse performOperation(final Double parameter1, final Double parameter2,
        final OperationType operationType) {

        if (areAnyNull(parameter1, parameter2, operationType)) throw new IllegalArgumentException();
        final BiFunction<Double, Double, OperationResponse> operation =
            operationFactory.getOperation(operationType);

        return operation.apply(parameter1, parameter2);
    }


    private boolean areAnyNull(final Object ... objects) {
        return Stream.of(objects).anyMatch(Objects::isNull);
    }
}
