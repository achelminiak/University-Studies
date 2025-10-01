package com.example.s29093Bank.account;

public class Account {
    int clientID;
    double balance;
    int accountID;

    public Account(int accountID, double balance, int clientID) {
        this.clientID = clientID;
        this.balance = balance;
        this.accountID = accountID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }
}
