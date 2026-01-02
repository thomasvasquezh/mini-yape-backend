package com.project.miniyape.wallet.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class MovementResponse {

    private String origin;
    private String destination;
    private BigDecimal amount;
    private String status;
    private LocalDateTime date;
}
