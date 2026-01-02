package com.project.miniyape.wallet.service;

import com.project.miniyape.wallet.domain.Movement;
import com.project.miniyape.wallet.dto.MovementResponse;
import com.project.miniyape.wallet.mapper.MovementMapper;
import com.project.miniyape.wallet.repository.MovementRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {
    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    @Transactional(readOnly = true)
    public List<MovementResponse> listByPhone(String phone) {
        return movementMapper.toMovementResponseList(
                movementRepository.findByOriginOrDestination(phone, phone)
        );
    }

}
