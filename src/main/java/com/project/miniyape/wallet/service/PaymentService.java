package com.project.miniyape.wallet.service;

import com.project.miniyape.user.domain.User;
import com.project.miniyape.user.repository.UserRepository;
import com.project.miniyape.wallet.domain.Movement;
import com.project.miniyape.wallet.repository.MovementRepository;
import com.project.miniyape.wallet.dto.PaymentRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final UserRepository userRepository;
    private final MovementRepository movementRepository;

    @Transactional
    public Movement processPayment(PaymentRequest paymentRequest){
        User origin = userRepository.findByPhone(paymentRequest.getOrigin())
                .orElseThrow(()-> new RuntimeException("Origin user doesn't exist"));

        User destination = userRepository.findByPhone(paymentRequest.getDestination())
                .orElseThrow(()-> new RuntimeException("Destination user doesn't exist"));

        BigDecimal amount = paymentRequest.getAmount();

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if(origin.getBalance().compareTo(amount)<0){
            throw new RuntimeException("insufficient balance");
        }

        if (origin.getPhone().equals(destination.getPhone())) {
            throw new RuntimeException("Origin and destination cannot be the same");
        }
        origin.setBalance(origin.getBalance().subtract(amount));
        destination.setBalance(destination.getBalance().add(amount));

        userRepository.save(origin);
        userRepository.save(destination);

        Movement mov = Movement.builder()
                .origin(origin.getPhone())
                .destination(destination.getPhone())
                .amount(amount)
                .status("EXECUTED")
                .message("Succesfull payment")
                .build();

        return movementRepository.save(mov);
    }


}
