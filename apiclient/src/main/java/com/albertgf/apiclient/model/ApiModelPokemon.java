package com.albertgf.apiclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiModelPokemon {
    @SerializedName("name")
    private String name;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("sprites")
    private ApiModelPokemonSprites sprites;
    @SerializedName("height")
    private Integer height;
    @SerializedName("id")
    private Integer id;
    @SerializedName("order")
    private Integer order;
    @SerializedName("base_experience")
    private Integer baseExperience;
    @SerializedName("types")
    private List<ApiModelPokemonTypes> types = null;

    // ****************************
    //      GETTERS AND SETTERS
    // ****************************


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

    public ApiModelPokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(ApiModelPokemonSprites sprites) {
        this.sprites = sprites;
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

    public List<ApiModelPokemonTypes> getTypes() {
        return types;
    }

    public void setTypes(List<ApiModelPokemonTypes> types) {
        this.types = types;
    }
}
