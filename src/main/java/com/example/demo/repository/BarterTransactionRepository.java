package com.example.demo.repository;

import com.example.demo.model.BarterTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarterTransactionRepository extends JpaRepository<BarterTransaction, Long> {
}
