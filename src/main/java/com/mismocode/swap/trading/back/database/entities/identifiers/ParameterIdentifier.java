package com.mismocode.swap.trading.back.database.entities.identifiers;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParameterIdentifier implements Serializable {
    private static final long serialVersionUID = -5512868898253239417L;

    @Column(name = "group", nullable = false)
    private String group;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final ParameterIdentifier that = (ParameterIdentifier) object;

        if (!group.equals(that.group)) return false;
        if (!type.equals(that.type)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = group.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
