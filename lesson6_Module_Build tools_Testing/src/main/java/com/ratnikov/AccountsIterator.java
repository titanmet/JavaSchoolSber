package com.ratnikov;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class AccountsIterator implements Iterator<AccountsImpl> {
    static List<AccountsImpl> accounts;
    static int curSize;

    public AccountsIterator(List<AccountsImpl> accounts) {
        AccountsIterator.accounts = accounts;
    }

    @Override
    public boolean hasNext() {
        return curSize < accounts.size();
    }

    @Override
    public AccountsImpl next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return accounts.get(curSize++);
    }

    public static void main(String[] args) {
        List<AccountsImpl> accounts = Arrays.asList(
                new AccountsImpl("user", "12345", "Alex", "Baldwin", "8928903451223", "Los-Angeles"),
                new AccountsImpl("user1", "12345", "Den", "Moll", "8928234451293", "Rostov"),
                new AccountsImpl("user2", "12345", "Sam", "Serious", "8928567451269", "Denver"));

        for(AccountsImpl acc: accounts){
            System.out.println(acc);
        }

    }
}
