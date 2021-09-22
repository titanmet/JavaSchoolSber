package com.ratnikov.lesson;

public class AccountTerminal {
    private final Account account;

    public AccountTerminal(Account account) {
        this.account = account;
    }

    public synchronized void makeWithdrawal(int amount) {
        if (this.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " " + this.getBalance());
            account.withdraw(amount);
        }
    }

    public int getBalance() {
        return account.getBalance();
    }


}
