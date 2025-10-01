package com.example.s29093Bank.account;

import com.example.s29093Bank.status.Status;
import com.example.s29093Bank.status.StatusService;
import com.example.s29093Bank.client.ClientService;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountStorage accountStorage;
    private final ClientService clientService;
    private final StatusService statusService;

    public AccountService(AccountStorage accountStorage, ClientService clientService, StatusService statusService) {
        this.accountStorage = accountStorage;
        this.clientService = clientService;
        this.statusService = statusService;
    }

    public Account findbyClientID(int clientID) {
        Account selectedAccount = null;
        for (Account account : accountStorage.getAccounts()) {
            if (account.getClientID() == clientID) {
                selectedAccount = account;
            }
            if (selectedAccount == null) {
                throw new RuntimeException("There is no Account with ID:" + clientID);
            }
        }
        return selectedAccount;
    }

    public void registration(double newBalance, String name, String surname) {
        int newAccountID = 1;
        for (Account account : accountStorage.getAccounts()) {
            newAccountID++;
        }
        clientService.registerClient(name, surname);
        int clientID = clientService.findClientID(newAccountID).getClientID();
        Account account = new Account(newAccountID, newBalance, clientID);
        accountStorage.newAccount(account);
    }

    public Status transfer(double amount, int clientID) {
        Account selectedAccount = findbyClientID(clientID);
        Status status;
        if (selectedAccount == null) {
            throw new RuntimeException("No registered client with ID:" + clientID);
        }
        if (selectedAccount.getBalance() < amount) {
            status = statusService.findStatusID(4);
            System.out.println("Not enough money on the bank account");
        } else {
            selectedAccount.balance -= amount;
            status = statusService.findStatusID(3);
        }
        return status;
    }

    public Status payment(double amount, int clientID) {
        Account selectedAccount = findbyClientID(clientID);
        Status status;
        if (selectedAccount == null) {
            status = statusService.findStatusID(4);
            throw new RuntimeException("Client is not registered");
        }
        if (amount <= 0) {
            status = statusService.findStatusID(4);
            throw new RuntimeException("Amount cannot be equal too zero");
        } else {
            selectedAccount.balance += amount;
            status = statusService.findStatusID(3);
        }
        return status;
    }
}