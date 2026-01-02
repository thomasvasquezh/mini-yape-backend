package com.project.miniyape.user.mapper;

import com.project.miniyape.user.domain.User;
import com.project.miniyape.user.dto.UserResponse;
import com.project.miniyape.user.dto.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userRequest(UserRequest userRequest){
        return User.builder()
                .phone(userRequest.getPhone())
                .name(userRequest.getName())
                .build();
    }

    public User userToResponse(UserResponse userResponse){
        return User.builder()
                .phone(userResponse.getPhone())
                .name(userResponse.getName())
                .balance(userResponse.getBalance())
                .build();
    }

}
