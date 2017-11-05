package com.albertgf.apiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by albertgf on 5/11/17.
 */

public class ApiModelPokemonType {
    @SerializedName ("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
