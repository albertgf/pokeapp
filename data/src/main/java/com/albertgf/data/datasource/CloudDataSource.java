package com.albertgf.data.datasource;

import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;

/**
 * Created by albertgf on 4/11/17.
 */

public interface CloudDataSource {
    ApiModelPokemon getPokemon(int id) throws ServerApiException, NetworkApiException;
}
