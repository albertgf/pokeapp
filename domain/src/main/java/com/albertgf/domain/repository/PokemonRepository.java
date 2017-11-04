package com.albertgf.domain.repository;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.DefaultCallback;

/**
 * Created by albertgf on 4/11/17.
 */

public interface PokemonRepository {
    void getPokemonById(int id, DefaultCallback<PokemonModelView> callback);
}
