package com.project.miniyape.wallet.web;

import com.project.miniyape.wallet.domain.Movement;
import com.project.miniyape.wallet.dto.MovementResponse;
import com.project.miniyape.wallet.dto.PaymentRequest;
import com.project.miniyape.wallet.dto.PaymentResponse;
import com.project.miniyape.wallet.mapper.MovementMapper;
import com.project.miniyape.wallet.service.MovementService;
import com.project.miniyape.wallet.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final MovementService movementService;
    private final MovementMapper movementMapper;

    @PostMapping("/payments")
    public ResponseEntity<PaymentResponse> yapear(@Valid @RequestBody PaymentRequest paymentRequest){
        Movement mov = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(movementMapper.toPaymentResponse(mov));
    }

    @GetMapping("/movements/{phone}")
    public ResponseEntity<List<MovementResponse>> movements(@PathVariable String phone) {
        return ResponseEntity.ok(movementService.listByPhone(phone));
    }


}
