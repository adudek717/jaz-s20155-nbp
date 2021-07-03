package com.example.jazs20155nbp.controller;

import com.example.jazs20155nbp.service.RequestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NbpController {

    private final RequestService requestService;

    @Autowired
    public NbpController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/average")
    @ApiOperation(value = "Return average of currency rate in given data range")
    public ResponseEntity<Double> getAverage(@RequestParam String currencyCode,
                                      @RequestParam String dateStart, @RequestParam String dateEnd) {
        Double result = requestService.getAverage(dateStart, dateEnd, currencyCode);
        return ResponseEntity.ok(result);
    }
}
