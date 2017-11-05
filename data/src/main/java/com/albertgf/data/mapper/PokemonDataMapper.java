package com.albertgf.data.mapper;

import com.albertgf.apiclient.model.ApiModelPokemon;
import com.albertgf.apiclient.model.ApiModelPokemonTypes;
import com.albertgf.data.model.PokemonDisk;
import com.albertgf.domain.model.PokemonModelView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.RealmResults;

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
            domain.setId(api.getId());
            domain.setName(api.getName());
            domain.setBaseExperience(api.getBaseExperience());
            domain.setHeight(api.getHeight());
            domain.setWeight(api.getWeight());
            domain.setOrder(api.getOrder());
            domain.setSpriteFront(api.getSprites().getFrontDefault());
            domain.setSpriteBack(api.getSprites().getBackDefault());
            domain.setTypes(transform(api.getTypes()));
        }

        return domain;
    }

    public PokemonModelView transform(PokemonDisk disk) {
        PokemonModelView domain = new PokemonModelView();

        if (disk != null) {
            domain.setId(disk.getId());
            domain.setName(disk.getName());
            domain.setBaseExperience(disk.getBaseExperience());
            domain.setHeight(disk.getHeight());
            domain.setWeight(disk.getWeight());
            domain.setOrder(disk.getOrder());
            domain.setSpriteFront(disk.getSpriteFront());
            domain.setSpriteBack(disk.getSpriteBack());
            domain.setTypes(disk.getTypes());
            domain.setCatched(disk.isCatched());
        }

        return domain;
    }

    private List<String> transform(List<ApiModelPokemonTypes> types) {
        List<String> domain = new ArrayList<>();

        if (types != null) {
            for (ApiModelPokemonTypes type : types) {
                domain.add(type.getType().getName());
            }
        }

        return domain;
    }

    public List<PokemonModelView> transform(RealmResults<PokemonDisk> disk) {
        List<PokemonModelView> domain = new ArrayList<>();

        if (disk != null) {
            for (PokemonDisk pokemon : disk) {
                domain.add(transform(pokemon));
            }
        }

        return domain;
    }
}
