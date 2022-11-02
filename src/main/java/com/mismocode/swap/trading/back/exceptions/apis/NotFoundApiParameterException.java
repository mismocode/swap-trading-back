package com.mismocode.swap.trading.back.exceptions.apis;

public class NotFoundApiParameterException extends ApiException {
    private final String group;
    private final String type;
    private final String name;

    public NotFoundApiParameterException(final String group, final String type, final String name) {
        this.group = group;
        this.type = type;
        this.name = name;
    }

    @Override
    public String getMessage() {
        return String.format("Not found parameter [%s] of type [%s] from group [%s]", this.name, this.type, this.group);
    }
}
