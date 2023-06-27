package com.scarlett;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Getters and setters

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Other methods

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateBalance(transaction);
    }

    private void updateBalance(Transaction transaction) {
        if (transaction.getType().equals("income")) {
            balance += transaction.getAmount();
        } else if (transaction.getType().equals("expense")) {
            balance -= transaction.getAmount();
        }
    }
}
