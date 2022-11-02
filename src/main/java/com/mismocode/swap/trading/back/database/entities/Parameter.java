package com.mismocode.swap.trading.back.database.entities;

import com.mismocode.swap.trading.back.database.entities.identifiers.ParameterIdentifier;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parameter", schema = "application")
public class Parameter {

    @EmbeddedId
    private ParameterIdentifier identifier;

    @Column(name = "value", length = 1000)
    private String value;

    public ParameterIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final ParameterIdentifier identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
