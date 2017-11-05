package com.albertgf.data.datasource;

import android.content.Context;

import com.albertgf.data.model.PokemonDisk;
import com.albertgf.domain.model.PokemonModelView;

/**
 * Created by albertgf on 4/11/17.
 */

public interface DiskDataSource {
    Context getContext();
    void closeDisk();

    void savePokemon(PokemonModelView pokemon);
    PokemonDisk getPokemon(int id);
}
