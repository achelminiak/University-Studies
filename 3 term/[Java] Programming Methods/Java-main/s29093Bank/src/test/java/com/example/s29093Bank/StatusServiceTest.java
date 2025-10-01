package com.example.s29093Bank;

import com.example.s29093Bank.status.Status;
import com.example.s29093Bank.status.StatusService;
import com.example.s29093Bank.status.StatusStorage;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatusServiceTest {

    @Mock
    StatusStorage statusStorage;

    @InjectMocks
    StatusService statusService;

    @Test
    public void shouldFindStatusByID() {
        // given
        int testStatusID = 1;
        when(statusStorage.getStatusList()).thenReturn(List.of(
                new Status(1, "Pending"),
                new Status(2, "In Progress"),
                new Status(3, "Accepted"),
                new Status(4, "Declined")
        ));

        // when
        Status status = statusService.findStatusID(testStatusID);

        // then
        assertThat(status.getStatusID()).isEqualTo(testStatusID);
        assertThat(status.getStatusName()).isEqualTo("Pending");
    }

    @Test
    public void shouldInvalidStatusID() {
        // given
        int invalidStatusID = 65656;
        when(statusStorage.getStatusList()).thenReturn(List.of(
                new Status(1, "Pending"),
                new Status(2, "In Progress"),
                new Status(3, "Accepted"),
                new Status(4, "Declined")
        ));

        // when
        Status status = statusService.findStatusID(invalidStatusID);

        // then
        assertThat(status).isNull();
    }
}
