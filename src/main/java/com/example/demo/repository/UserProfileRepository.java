package com.example.demo.repository;

import com.example.demo.model.BarterTransaction;
import java.util.Optional;

public interface BarterTransactionRepository {

    BarterTransaction save(BarterTransaction transaction);

    Optional<BarterTransaction> findById(Long id);
}
