package com.example.jazs20155nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RequestRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private LocalDate start;
    private LocalDate end;
    private Double currencyRate;
    private LocalDateTime requestTime;

    public RequestRecord() {
    }

    public RequestRecord(String currencyCode, LocalDate start, LocalDate end, Double currencyRate) {
        this.currency = currencyCode;
        this.start = start;
        this.end = end;
        this.currencyRate = currencyRate;
        this.requestTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currencyCode) {
        this.currency = currencyCode;
    }

    public Double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
