package com.albertgf.apiclient;

/**
 * Created by albertgf on 4/11/17.
 */

public class ApiClientTest {
    private static final String ANY_HOST_URL = "http://pokeapi.co/api/v2/";

    public static ApiClient givenPokeApiClient() {
        ApiConfig apiConfig = new ApiConfig.Builder(ANY_HOST_URL).debug().build();
        return new ApiClient(apiConfig);
    }
}
