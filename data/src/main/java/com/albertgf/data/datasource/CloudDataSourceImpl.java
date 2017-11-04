package com.albertgf.data.datasource;

import com.albertgf.apiclient.ApiClient;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;

/**
 * Created by albertgf on 4/11/17.
 */

public class CloudDataSourceImpl implements CloudDataSource {
    private final ApiClient apiClient;

    public CloudDataSourceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override public ApiModelPokemon getPokemon(int id) throws ServerApiException, NetworkApiException {
        return apiClient.getPokemon(id);
    }
}
