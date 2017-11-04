package com.albertgf.apiclient;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by albertgf on 4/11/17.
 */

@RunWith (AndroidJUnit4.class)
@SmallTest
public class ApiGetPokemonTest {

    private ApiClient client;

    @Before
    public void setup() {
        client = ApiClientTest.givenPokeApiClient();
    }

    @Test
    public void givenPokemonIdShouldGetPokemon()
            throws ServerApiException, NetworkApiException {
        ApiModelPokemon pokemon = client.getPokemon(1);
        org.junit.Assert.assertNotNull(pokemon);
    }
}

