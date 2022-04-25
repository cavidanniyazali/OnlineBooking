package com.company.onlinebooking.repositories;

import com.company.onlinebooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}