package com.example.demo.repository;

import com.example.demo.model.BarterTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BarterTransactionRepository extends JpaRepository<BarterTransaction, Long> {
    Optional<BarterTransaction> findByMatchRecord_Id(Long matchId);
}