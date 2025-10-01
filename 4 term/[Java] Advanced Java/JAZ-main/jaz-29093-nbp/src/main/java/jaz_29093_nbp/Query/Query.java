package jaz_29093_nbp.Query;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "query_history")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID of the query", name = "id", type = "int")
    private Long id;

    @Schema(description = "Currency's code", name = "currency", type = "String")
    private String currency;

    @Schema(description = "Start date of the query", name = "startDate", type = "LocalDate")
    private LocalDate startDate;

    @Schema(description = "End date of the query", name = "endDate", type = "LocalDate")
    private LocalDate endDate;


    @Schema(description = "Avarage rate for the query")
    private Double averageRate;
    @Schema(description = "Returning Current Time")
    private LocalDateTime currentTime;

    public Query() {
    }

    public Query(String currency, LocalDate startDate, LocalDate endDate, Double averageRate, LocalDateTime currentTime) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.averageRate = averageRate;
        this.currentTime = currentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
