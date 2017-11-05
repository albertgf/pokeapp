package com.albertgf.pokeapp.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.adapter.DefaultViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by albertgf on 5/11/17.
 */

public class PokemonHolder extends DefaultViewHolder<PokemonModelView> {
    private TextView tvName;
    private ImageView ivPokemon;

    public PokemonHolder(View view) {
        super(view);

        this.tvName = view.findViewById(R.id.cell_view_pokemon_tv_name);
        ivPokemon = view.findViewById(R.id.cell_view_pokemon_iv);
    }

    @Override
    public void bindData(@NonNull PokemonModelView data) {
        tvName.setText(data.getName());

        Glide.with(ivPokemon).load(data.getSpriteFront()).into(ivPokemon);
    }
}
