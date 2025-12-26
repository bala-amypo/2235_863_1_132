package com.example.demo.repository;

import com.example.demo.model.demoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface demoTransactionRepository extends JpaRepository<demoTransaction, Long> {
}
