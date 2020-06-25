package org.jmb.calculatorapi.domain.service;

import javax.validation.ValidationException;

import org.jmb.calculatorapi.domain.model.OperationResponse;
import org.jmb.calculatorapi.domain.model.OperationType;

public interface OperationalCalculatorService {
    /**
     * Perform operation identified by operation type applying to parameter1 and parameter2
     * @throws IllegalArgumentException If some parameter is null
     * @throws ValidationException If the parameters are not valid for the operation
     * @param parameter1
     * @param parameter2
     * @param operationType
     * @return
     */
    OperationResponse performOperation(final Double parameter1, final Double parameter2, final OperationType operationType);
}
