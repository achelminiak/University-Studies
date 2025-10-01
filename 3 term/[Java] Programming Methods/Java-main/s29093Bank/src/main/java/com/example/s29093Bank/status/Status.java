package com.example.s29093Bank.status;

public class Status {
    int statusID;
    String statusName;

    public Status(int statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public int getStatusID() {
        return statusID;
    }

    public String getStatusName() {
        return statusName;
    }
}
