package com.albertgf.apiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by albertgf on 5/11/17.
 */

public class ApiModelPokemonSprites {
    @SerializedName ("back_default")
    private String backDefault;
    @SerializedName("front_default")
    private String frontDefault;

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}
