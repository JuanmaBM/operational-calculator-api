package org.jmb.calculatorapi.domain.service.operation;

import javax.validation.ValidationException;

import org.jmb.calculatorapi.domain.model.OperationResponse;

public abstract class GenericOperationComponent {

    /**
     * Checks if parameter1 and parameter2 satisfies the restriction for perform the operation successfully
     * @param parameter1
     * @param parameter2
     * @return
     */
    protected abstract boolean isValid(final Double parameter1, final Double parameter2);

    /**
     * Apply operation to parameter1 and parameter2
     * @param parameter1
     * @param parameter2
     * @return
     */
    protected abstract Double executeOperation(final Double parameter1, final Double parameter2);

    public OperationResponse calculate(final Double parameter1, final Double parameter2) {
        if (!isValid(parameter1, parameter2)) throw new ValidationException();
        final Double result = executeOperation(parameter1, parameter2);
        return OperationResponse.builder().result(result).build();
    }
}
