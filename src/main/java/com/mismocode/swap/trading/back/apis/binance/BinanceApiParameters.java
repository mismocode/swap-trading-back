package com.mismocode.swap.trading.back.apis.binance;

import com.mismocode.swap.trading.back.apis.ApiParameters;
import com.mismocode.swap.trading.back.database.entities.Parameter;
import com.mismocode.swap.trading.back.exceptions.apis.NotFoundApiParameterException;
import com.mismocode.swap.trading.back.services.database.ParameterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinanceApiParameters implements ApiParameters {
    private static final String PARAMETERS_TYPE = "binance-api";
    private static final String API_NAME_PARAMETER_NAME = "api-name";
    private static final String API_KEY_PARAMETER_NAME = "api-key";
    private static final String SECRET_KEY_PARAMETER_NAME = "secret-key";

    private final ParameterService parameterService;

    protected String apiName;
    protected String apiKey;
    protected String secretKey;

    @Autowired
    public BinanceApiParameters(final ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @Override
    public void fillParameters(final String group) throws NotFoundApiParameterException {
        final List<Parameter> parameters = this.parameterService.get(group, PARAMETERS_TYPE);
        boolean existsApiName = false, existsApiKey = false, existsSecretKey = false;
        for(final Parameter parameter: parameters){
            switch(parameter.getIdentifier().getName()){
                case API_NAME_PARAMETER_NAME:
                    existsApiName = true;
                    this.validateParameter(parameter);
                    this.apiName = parameter.getValue();
                    break;
                case API_KEY_PARAMETER_NAME:
                    existsApiKey = true;
                    this.validateParameter(parameter);
                    this.apiKey = parameter.getValue();
                    break;
                case SECRET_KEY_PARAMETER_NAME:
                    existsSecretKey = true;
                    this.validateParameter(parameter);
                    this.secretKey = parameter.getValue();
                    break;
            }
        }
        if(!existsApiName){
            throw new NotFoundApiParameterException(group, PARAMETERS_TYPE, API_NAME_PARAMETER_NAME);
        } else if(!existsApiKey){
            throw new NotFoundApiParameterException(group, PARAMETERS_TYPE, API_KEY_PARAMETER_NAME);
        } else if(!existsSecretKey){
            throw new NotFoundApiParameterException(group, PARAMETERS_TYPE, SECRET_KEY_PARAMETER_NAME);
        }
    }

    public String getApiName() {
        return this.apiName;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    private void validateParameter(final Parameter parameter) throws NotFoundApiParameterException {
        if(StringUtils.isBlank(parameter.getValue())){
            throw new NotFoundApiParameterException(
                    parameter.getIdentifier().getGroup(),
                    parameter.getIdentifier().getType(),
                    parameter.getIdentifier().getName()
            );
        }
    }
}
