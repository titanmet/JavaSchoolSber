package com.ratnikov.hwspringbootterminal.controller;

import com.ratnikov.hwspringbootterminal.model.Account;
import com.ratnikov.hwspringbootterminal.model.Transation;
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
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping
    public ResponseEntity<Transation> create(@RequestBody @Valid Transation transation) {
        Optional<Account> optionalAccount = accountRepository.findById(transation.getAccount().getId());
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transation.setAccount(optionalAccount.get());

        Transation savedTransaction = transactionRepository.save(transation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTransaction.getId()).toUri();

        return ResponseEntity.created(location).body(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transation> update(@RequestBody @Valid Transation transation, @PathVariable Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(transation.getAccount().getId());
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Transation> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transation.setAccount(optionalAccount.get());
        transation.setId(optionalTransaction.get().getId());
        transactionRepository.save(transation);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transation> delete(@PathVariable Integer id) {
        Optional<Transation> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionRepository.delete(optionalTransaction.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Transation>> getAll(Pageable pageable) {
        return ResponseEntity.ok(transactionRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transation> getById(@PathVariable Integer id) {
        Optional<Transation> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalTransaction.get());
    }
}
