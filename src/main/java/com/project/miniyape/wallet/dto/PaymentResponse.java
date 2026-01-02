package com.project.miniyape.wallet.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentResponse {

    private String status;
    private String message;
    private String origin;
    private String destination;
    private BigDecimal amount;

}
