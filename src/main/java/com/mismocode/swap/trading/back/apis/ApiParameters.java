package com.mismocode.swap.trading.back.apis;

import com.mismocode.swap.trading.back.exceptions.apis.NotFoundApiParameterException;

public interface ApiParameters {
    void fillParameters(final String group) throws NotFoundApiParameterException;
}
