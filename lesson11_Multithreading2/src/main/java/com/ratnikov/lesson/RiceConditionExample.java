package com.ratnikov.lesson;

import java.util.ArrayList;
import java.util.List;

public class RiceConditionExample {

    static class AccountTask implements Runnable {
        AccountTerminal accountTerminal;

        public AccountTask(AccountTerminal accountTerminal) {
            this.accountTerminal = accountTerminal;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                accountTerminal.makeWithdrawal(10);
                if (accountTerminal.getBalance() < 0) {
                    System.out.println("Account is overdrawn");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(500000);
        AccountTerminal acct = new AccountTerminal(account);
        AccountTerminal acct2 = new AccountTerminal(account);
        AccountTerminal acct3 = new AccountTerminal(account);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            threadList.add(new Thread(new AccountTask(acct)));
        }
        for (int i = 0; i < 2500; i++) {
            threadList.add(new Thread(new AccountTask(acct2)));
        }
        for (int i = 0; i < 2500; i++) {
            threadList.add(new Thread(new AccountTask(acct3)));
        }
        long start = System.currentTimeMillis();
        for(Thread thread : threadList) {
            thread.start();
        }
        for(Thread thread : threadList) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Account balance: "+acct.getBalance());
        System.out.println("Time: " + (end-start));
    }
}
