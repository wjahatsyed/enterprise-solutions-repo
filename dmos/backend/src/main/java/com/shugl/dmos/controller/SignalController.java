package com.shugl.dmos.controller;

import com.shugl.dmos.model.Signal;
import com.shugl.dmos.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    @Autowired
    private SignalService service;

    @GetMapping("/signals")
    public Iterable<Signal> getSignals() {
        return service.getAllSignals();
    }
}
