package com.example.s29093Bank.client;

import com.example.s29093Bank.account.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ClientStorage {
    List<Client> clients = new ArrayList<Client>();

    public ClientStorage() {
        clients.add(new Client(1, "Bartuś", "Futerkowski"));
        clients.add(new Client(2, "Frogtuś", "Żabuś"));
        clients.add(new Client(3, "Myszuś", "Moususiowski"));
        clients.add(new Client(4, "Tortuś", "ŻÓłwiś"));
    }

    public List<Client> getClients() {
        return clients;
    }

    public void newClient(Client client) {
        clients.add(client);
    }
}
