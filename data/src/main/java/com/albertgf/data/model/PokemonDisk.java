package com.albertgf.data.model;

import com.albertgf.domain.model.PokemonSpritesModelView;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by albertgf on 5/11/17.
 */

public class PokemonDisk extends RealmObject {
    @PrimaryKey
    private Integer id;
    private String name;
    private Integer weight;
    private String spriteFront;
    private String spriteBack;
    private Integer height;
    private Integer order;
    private Integer baseExperience;
    private RealmList<String> types = null;
    private boolean isCatched = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSpriteFront() {
        return spriteFront;
    }

    public void setSpriteFront(String spriteFront) {
        this.spriteFront = spriteFront;
    }

    public String getSpriteBack() {
        return spriteBack;
    }

    public void setSpriteBack(String spriteBack) {
        this.spriteBack = spriteBack;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(RealmList<String> types) {
        this.types = types;
    }

    public boolean isCatched() {
        return isCatched;
    }

    public void setCatched(boolean catched) {
        isCatched = catched;
    }
}
