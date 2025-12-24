package com.example.demo.repository;

import com.example.demo.model.demoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface demoTransactionRepository extends JpaRepository<demoTransaction, Long> {

    List<demoTransaction> findByStatus(String status);

    List<demoTransaction> findByMatchId(Long matchId);
}
