package org.jmb.calculatorapi.domain.service.operation;

import org.springframework.stereotype.Component;

@Component
public class SubOperationComponent extends GenericOperationComponent {

    @Override
    protected boolean isValid(final Double parameter1, final Double parameter2) {
        return parameter1 != null && parameter2 != null;
    }

    @Override
    protected Double executeOperation(final Double parameter1, final Double parameter2) {
        return parameter1 - parameter2;
    }
}
