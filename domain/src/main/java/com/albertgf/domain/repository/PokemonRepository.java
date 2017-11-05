package com.albertgf.domain.repository;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.DefaultCallback;

import java.util.List;

/**
 * Created by albertgf on 4/11/17.
 */

public interface PokemonRepository {
    void getPokemons(DefaultCallback<List<PokemonModelView>> callback);
    void getPokemonById(int id, DefaultCallback<PokemonModelView> callback);
    void catchPokemon(PokemonModelView pokemon, DefaultCallback<Object> callback);
}
