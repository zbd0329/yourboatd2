package com.example.yourboard.repository;

import com.example.yourboard.entity.Reple;
import com.example.yourboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepleRepository extends JpaRepository<Reple, Long> {

    Optional<Reple> findByIdAndUser(Long id, User user);
    void deleteByBoardId(Long id);
}
