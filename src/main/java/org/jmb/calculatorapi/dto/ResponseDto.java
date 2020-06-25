package org.jmb.calculatorapi.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 796614270500053391L;
    private Double result;
}
