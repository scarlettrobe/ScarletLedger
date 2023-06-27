package com.scarlett;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date date;
    private String type;
    private String description;

    public Transaction(double amount, Date date, String type, String description) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.description = description;
    }

    // Getters and setters

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
