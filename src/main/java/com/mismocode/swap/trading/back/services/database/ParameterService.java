package com.mismocode.swap.trading.back.services.database;

import com.mismocode.swap.trading.back.database.entities.Parameter;
import com.mismocode.swap.trading.back.database.repositories.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {
    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterService(final ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public List<Parameter> get(final String group, final String type) {
        return this.parameterRepository.findByIdentifierGroupAndIdentifierType(group, type);
    }
}
