package com.ratnikov.hwspringbootterminal.repository;

import com.ratnikov.hwspringbootterminal.model.Transation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transation, Integer> {
}
