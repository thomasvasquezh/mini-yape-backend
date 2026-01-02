package com.project.miniyape.user.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRequest {
    @NotBlank
    private String phone;

    @NotBlank
    private String name;

}
