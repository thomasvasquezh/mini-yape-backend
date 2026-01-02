package com.project.miniyape.user.service;

import com.project.miniyape.user.domain.User;
import com.project.miniyape.user.dto.UserRequest;
import com.project.miniyape.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(UserRequest userRequest){
       if(userRepository.findByPhone(userRequest.getPhone()).isPresent()){
           throw new RuntimeException("User already exists");
       }
       User newUser = User.builder()
               .phone(userRequest.getPhone())
               .name(userRequest.getName())
               .balance(BigDecimal.ZERO)
               .build();

       return userRepository.save(newUser);
    }

    public User getByPhone(String phone){
        return userRepository.findByPhone(phone)
                .orElseThrow(()-> new RuntimeException("User not found"));

    }

}
