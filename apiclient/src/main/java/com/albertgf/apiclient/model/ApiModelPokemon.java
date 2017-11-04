package com.albertgf.apiclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiModelPokemon {
    @SerializedName("pokemon") private String name;

    // ****************************
    //      GETTERS AND SETTERS
    // ****************************


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
