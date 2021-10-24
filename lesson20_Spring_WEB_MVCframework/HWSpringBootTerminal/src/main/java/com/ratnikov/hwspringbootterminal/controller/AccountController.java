package com.ratnikov.hwspringbootterminal.controller;

import com.ratnikov.hwspringbootterminal.model.Account;
import com.ratnikov.hwspringbootterminal.repository.AccountRepository;
import com.ratnikov.hwspringbootterminal.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody Account account) {
        Account savedAccount = accountRepository.save(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAccount.getId()).toUri();

        return ResponseEntity.created(location).body(savedAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Integer id, @Valid @RequestBody Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        account.setId(optionalAccount.get().getId());
        accountRepository.save(account);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        accountRepository.delete(optionalAccount.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalAccount.get());
    }

    @GetMapping
    public ResponseEntity<Page<Account>> getAll(Pageable pageable) {
        return ResponseEntity.ok(accountRepository.findAll(pageable));
    }
}
