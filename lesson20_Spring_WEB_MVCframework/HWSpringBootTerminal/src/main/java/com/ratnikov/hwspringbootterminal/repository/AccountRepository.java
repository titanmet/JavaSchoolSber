package com.ratnikov.hwspringbootterminal.repository;

import com.ratnikov.hwspringbootterminal.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
