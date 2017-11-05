package com.albertgf.data.mapper;

import com.albertgf.apiclient.model.ApiModelPokemon;
import com.albertgf.apiclient.model.ApiModelPokemonSprites;
import com.albertgf.apiclient.model.ApiModelPokemonTypes;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.model.PokemonSpritesModelView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albertgf on 5/11/17.
 */
@Singleton
public class PokemonDataMapper {

    @Inject
    public PokemonDataMapper() {
    }

    public PokemonModelView transform(ApiModelPokemon api) {
        PokemonModelView domain = new PokemonModelView();

        if (api != null) {
            domain.setName(api.getName());
            domain.setBaseExperience(api.getBaseExperience());
            domain.setHeight(api.getHeight());
            domain.setWeight(api.getWeight());
            domain.setOrder(api.getOrder());
            domain.setSprites(transform(api.getSprites()));
            domain.setTypes(transform(api.getTypes()));
        }

        return domain;
    }

    private PokemonSpritesModelView transform(ApiModelPokemonSprites api) {
        PokemonSpritesModelView domain = new PokemonSpritesModelView();

        if (api != null) {
            domain.setBackDefault(api.getBackDefault());
            domain.setFrontDefault(api.getFrontDefault());

        }

        return domain;
    }

    private List<String> transform(List<ApiModelPokemonTypes> types) {
        List<String> domain = new ArrayList<>();

        if (types != null) {
            for(ApiModelPokemonTypes type : types) {
                domain.add(type.getType().getName());
            }
        }

        return domain;
    }
}
