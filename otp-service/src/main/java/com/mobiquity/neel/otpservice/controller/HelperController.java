package com.mobiquity.neel.otpservice.controller;


import com.mobiquity.neel.otpservice.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelperController {

    private HelperService helperService;

    @Autowired
    public HelperController(HelperService helperService) {
        this.helperService = helperService;
    }

    @PutMapping(
            value = "/populate-data",
            consumes = { "application/json" }
    )
    public ResponseEntity<Void> populateData() {
        return helperService.populateData();
    }
}
