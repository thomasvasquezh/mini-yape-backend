package com.project.miniyape.wallet.mapper;

import com.project.miniyape.wallet.domain.Movement;
import com.project.miniyape.wallet.dto.MovementResponse;
import com.project.miniyape.wallet.dto.PaymentResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovementMapper {

    public PaymentResponse toPaymentResponse(Movement movement) {
        return PaymentResponse.builder()
                .status(movement.getStatus())
                .message(movement.getMessage())
                .origin(movement.getOrigin())
                .destination(movement.getDestination())
                .amount(movement.getAmount())
                .build();
    }

    public MovementResponse toMovementResponse(Movement movement) {
        return MovementResponse.builder()
                .origin(movement.getOrigin())
                .destination(movement.getDestination())
                .amount(movement.getAmount())
                .status(movement.getStatus())
                .date(movement.getDate())
                .build();
    }

    public List<MovementResponse> toMovementResponseList(List<Movement> movements) {
        return movements.stream()
                .map(this::toMovementResponse)
                .toList();
    }
}
