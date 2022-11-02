package com.mismocode.swap.trading.back.database.repositories;

import com.mismocode.swap.trading.back.database.entities.Parameter;
import com.mismocode.swap.trading.back.database.entities.identifiers.ParameterIdentifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends CrudRepository<Parameter, ParameterIdentifier> {
    List<Parameter> findByIdentifierGroupAndIdentifierType(final String group, final String type);
}
