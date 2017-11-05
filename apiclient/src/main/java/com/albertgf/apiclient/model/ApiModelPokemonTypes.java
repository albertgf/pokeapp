package com.albertgf.apiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by albertgf on 5/11/17.
 */

public class ApiModelPokemonTypes {
    @SerializedName ("type")
    private ApiModelPokemonType type;

    public ApiModelPokemonType getType() {
        return type;
    }

    public void setType(ApiModelPokemonType type) {
        this.type = type;
    }
}
