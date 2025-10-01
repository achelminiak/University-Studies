package com.example.s29093Bank.account;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class AccountStorage {
    List<Account> accounts = new ArrayList<Account>();

    public AccountStorage() {
        accounts.add(new Account(1, 389000.51, 99999));
        accounts.add(new Account(2, 80, 101));
        accounts.add(new Account(3, 12345, 4444));
        accounts.add(new Account(4, 8000000, 5));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void newAccount(Account account) {
        accounts.add(account);
    }
}
