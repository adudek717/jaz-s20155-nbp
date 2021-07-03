package com.example.jazs20155nbp.service;

import com.example.jazs20155nbp.exception.custom.InvalidDateException;
import com.example.jazs20155nbp.model.NbpResponse;
import com.example.jazs20155nbp.model.Rate;
import com.example.jazs20155nbp.model.RequestRecord;
import com.example.jazs20155nbp.repository.RequestRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class RequestServiceImpl implements RequestService {
    private static final String NBP_URL = "http://api.nbp.pl/api/exchangerates/rates/a/";

    private final RequestRecordRepository requestRecordRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public RequestServiceImpl(RequestRecordRepository requestRecordRepository, RestTemplate restTemplate) {
        this.requestRecordRepository = requestRecordRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Double getAverage(String dateStart, String dateEnd, String currencyCode) {
        LocalDate start = getValidDate(dateStart);
        LocalDate end = getValidDate(dateEnd);
        String url = NBP_URL + currencyCode + "/" + start + "/" + end;
        NbpResponse nbpResponse = restTemplate.getForObject(url, NbpResponse.class);
        Double currencyRate = nbpResponse.getRates().stream()
                .mapToDouble(Rate::getMid)
                .average().orElse(0d);
        RequestRecord requestRecord = new RequestRecord(nbpResponse.getCurrency(), start, end, currencyRate);
        requestRecordRepository.save(requestRecord);
        return currencyRate;
    }

    private LocalDate getValidDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateException(date);
        }
    }
}
