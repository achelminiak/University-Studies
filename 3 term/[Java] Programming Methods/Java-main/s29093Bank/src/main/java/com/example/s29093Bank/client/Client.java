package com.example.s29093Bank.client;

public class Client {
    int clientID;
    String clientName;
    String clientSurname;

    public Client(int clientID, String clientName, String clientSurname) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

}
