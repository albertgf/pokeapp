package com.albertgf.apiclient.api;

import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;

/**
 * Created by albertgf on 4/11/17.
 */

public interface ApiPokemon {
    ApiModelPokemon getPokemon(int id) throws NetworkApiException, ServerApiException;
}
