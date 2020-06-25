package org.jmb.calculatorapi.domain.validation;

public interface ValidationService<T> {
    boolean validate(final Double parameter1, final Double parameter2);
}
