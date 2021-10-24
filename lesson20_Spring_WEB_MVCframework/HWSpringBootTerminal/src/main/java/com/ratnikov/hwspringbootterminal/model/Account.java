package com.ratnikov.hwspringbootterminal.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    private double balance;
    private String date;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transation> transactions = new HashSet<>();


    public Set<Transation> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transation> transactions) {
        this.transactions = transactions;
        for(Transation t : transactions) {
            t.setAccount(this);
        }
    }
}