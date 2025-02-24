package com.previred.previredchallenge.repository;

import com.previred.previredchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}