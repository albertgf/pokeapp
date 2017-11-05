package com.albertgf.data.mapper;

import com.albertgf.data.model.PokemonDisk;
import com.albertgf.domain.model.PokemonModelView;

import io.realm.RealmList;

/**
 * Created by albertgf on 5/11/17.
 */

public class DiskMapper {
    public static PokemonDisk buildHealthInfoDiskModel(PokemonModelView model) {
        PokemonDisk disk = new PokemonDisk();

        if(model!= null) {
            disk.setId(model.getId());
            disk.setBaseExperience(model.getBaseExperience());
            disk.setCatched(true);
            disk.setName(model.getName());
            disk.setHeight(model.getHeight());
            disk.setWeight(model.getWeight());
            disk.setSpriteBack(model.getSpriteBack());
            disk.setSpriteFront(model.getSpriteFront());
            disk.setOrder(model.getOrder());
            disk.setTypes((RealmList<String>) model.getTypes());
        }

        return disk;
    }
}
