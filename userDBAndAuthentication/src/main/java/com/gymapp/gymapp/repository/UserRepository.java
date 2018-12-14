package com.gymapp.gymapp.repository;

import com.gymapp.gymapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
