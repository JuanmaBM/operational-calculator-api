package org.jmb.calculatorapi.web.exception;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError implements Serializable {
    private static final long serialVersionUID = 4227420762162679660L;
    private Integer code;
    private String message;
}
