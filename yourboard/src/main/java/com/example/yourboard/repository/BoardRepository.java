package com.example.yourboard.repository;

import com.example.yourboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();


    Optional<Object> findByIdAndUserId(Long id, Long id1);

}
