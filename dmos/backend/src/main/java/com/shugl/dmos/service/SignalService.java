package com.shugl.dmos.service;

import com.shugl.dmos.model.Signal;
import com.shugl.dmos.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalService {

    @Autowired
    private SignalRepository repository;

    public Iterable<Signal> getAllSignals() {
        return repository.findAll();
    }
}
