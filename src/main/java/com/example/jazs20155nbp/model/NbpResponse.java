package com.example.jazs20155nbp.model;

import com.example.jazs20155nbp.model.Rate;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

public class NbpResponse {
    private String table;
    private String currency;
    private String code;

    @Column(name="arguments")
    @ElementCollection(targetClass=String.class)
    private List<Rate> rates;

    public NbpResponse(){}

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
