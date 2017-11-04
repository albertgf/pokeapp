package com.albertgf.apiclient.api;

import com.albertgf.apiclient.model.ApiModelPokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by albertgf on 3/11/17.
 */

public interface RestApi {

    @GET (RestPath.GET_POKEMON_PATH) Call<ApiModelPokemon> getPokemon(
            @Path ("id") int id
    );
}
