package com.albertgf.apiclient;

import com.albertgf.apiclient.api.ApiPokemon;
import com.albertgf.apiclient.api.RestApi;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;
import com.albertgf.apiclient.model.ApiModelResponse;

import java.io.IOException;

import retrofit2.Response;

import static com.albertgf.apiclient.Constants.CODE_NOT_FOUND;
import static com.albertgf.apiclient.Constants.CODE_SUCCESS;
import static com.albertgf.apiclient.exception.GenerateException.manageError;
import static com.albertgf.apiclient.exception.GenerateException.manageNotFoundError;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiClient implements ApiPokemon{
    private final ApiConfig apiConfig;

    public ApiClient(ApiConfig config) {
        if (config == null)
            throw new IllegalArgumentException("ApiConfig cannot be null");
        this.apiConfig = config;
    }

    private RestApi call() {
        return apiConfig.getApi();
    }

    //Response
    private ApiModelResponse buildResponse(Response response) {
        ApiModelResponse apiResponse = new ApiModelResponse();
        apiResponse.setStatus(response.code());
        return apiResponse;
    }

    @Override public ApiModelPokemon getPokemon(int id) throws NetworkApiException, ServerApiException, NotFoundApiException {
        try {
            Response<ApiModelPokemon> response = call().getPokemon(id).execute();
            switch (response.code()) {
                case CODE_SUCCESS:
                    return response.body();
                case CODE_NOT_FOUND:
                    manageNotFoundError(CODE_NOT_FOUND);
                default:
                    //TODO
                    //manageServerError(generateApiError(response.errorBody()), response.code());
                    return null;
            }
        } catch (IOException error) {
            manageError(error);
            return null;
        }
    }
}
