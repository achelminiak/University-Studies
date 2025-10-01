package com.example.s29093Bank.client;

import com.example.s29093Bank.account.Account;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public Client findClientID(int clientID) {
        Client selectedClient = null;
        for (Client client : clientStorage.getClients()) {
            if (client.getClientID() == clientID) {
                selectedClient = client;
            }
            if (selectedClient == null) {
                throw new RuntimeException("There is no registered Client with ID:" + clientID);
            }
        }
        return selectedClient;
    }

    public void getClientData(int clientID) {
        Client client = findClientID(clientID);
        System.out.println("Client ID: " + client.getClientID() + ", Name: " + client.getClientName() + ", Surname: " + client.getClientSurname());
    }

    public void registerClient(String name, String surname) {
        int newClientID = 1;
        for (Client client : clientStorage.getClients()) {
            newClientID++;
        }
        Client newClient = new Client(newClientID, name, surname);
        clientStorage.newClient(newClient);
    }
}

