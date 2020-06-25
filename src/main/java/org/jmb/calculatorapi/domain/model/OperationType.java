package org.jmb.calculatorapi.domain.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum OperationType {
    SUM("sum"),
    SUB("sub");

    private String code;

    OperationType(final String code) {
        this.code = code;
    }

    public Optional<OperationType> from(final String code) {
        return code != null
            ? Stream.of(OperationType.values()).filter(x -> x.code.equalsIgnoreCase(code)).findFirst()
            : Optional.empty();
    }
}
