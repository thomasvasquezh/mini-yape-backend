package com.project.miniyape.user.repository;

import com.project.miniyape.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPhone(String phone);
}
