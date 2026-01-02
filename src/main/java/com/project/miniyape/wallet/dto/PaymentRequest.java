package com.project.miniyape.wallet.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    @NotBlank(message = "The originating phone number is required")
    private String origin;

    @NotBlank(message = "The originating phone number is required")
    private String destination;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.10", message = "Amount must be at least 0.10")
    private BigDecimal amount;
}
