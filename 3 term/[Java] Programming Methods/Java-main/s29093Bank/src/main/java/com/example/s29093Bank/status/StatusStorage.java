package com.example.s29093Bank.status;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class StatusStorage {
    List<Status> statusList = new ArrayList<Status>();

    public StatusStorage() {
        statusList.add(new Status(1, "Pending"));
        statusList.add(new Status(2, "In Progress"));
        statusList.add(new Status(3, "Accepted"));
        statusList.add(new Status(4, "Declined"));
    }

    public List<Status> getStatusList() {
        return statusList;
    }
}
