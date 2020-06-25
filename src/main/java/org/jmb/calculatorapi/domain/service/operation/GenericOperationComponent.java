package org.jmb.calculatorapi.domain.service.operation;

import javax.validation.ValidationException;

import org.jmb.calculatorapi.domain.model.OperationResponse;

public abstract class GenericOperationComponent {

    protected abstract boolean isValid(final Double parameter1, final Double parameter2);
    protected abstract Double executeOperation(final Double parameter1, final Double parameter2);

    public OperationResponse calculate(final Double parameter1, final Double parameter2) {
        if (!isValid(parameter1, parameter2)) throw new ValidationException();
        final Double result = executeOperation(parameter1, parameter2);
        return OperationResponse.builder().result(result).build();
    }
}
