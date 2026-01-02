package com.project.miniyape.user.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserResponse {
    private String phone;
    private String name;
    private BigDecimal balance;
}
