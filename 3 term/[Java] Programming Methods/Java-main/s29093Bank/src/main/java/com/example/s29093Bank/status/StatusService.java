package com.example.s29093Bank.status;

import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private final StatusStorage statusStorage;

    public StatusService(StatusStorage statusStorage) {
        this.statusStorage = statusStorage;
    }

    public Status findStatusID(int statusID) {
        Status selectedStatus = null;
        for (Status status : statusStorage.getStatusList()) {
            if (status.getStatusID() == statusID) {
                selectedStatus = status;
            }
        }
        return selectedStatus;
    }
}