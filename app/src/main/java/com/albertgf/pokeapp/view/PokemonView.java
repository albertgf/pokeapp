package com.albertgf.pokeapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 5/11/17.
 */

public class PokemonView extends LinearLayout {
    @BindView (R.id.view_pokemon_iv_front) public ImageView ivPokemon;
    @BindView (R.id.view_pokemon_tv_name) TextView tvName;
    @BindView (R.id.view_pokemon_tv_height) TextView tvHeight;
    @BindView (R.id.view_pokemon_tv_weight) TextView tvWeight;

    public PokemonView(Context context) {
        this(context, null);
    }

    public PokemonView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PokemonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(getContext(), R.layout.view_pokemon_detail, this);
        ButterKnife.bind(this, view);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        view.setLayoutParams(params);
        setOrientation(VERTICAL);
    }

    public void bindData(PokemonModelView pokemon) {
        tvName.setText(pokemon.getName());
        tvHeight.setText(String.format("%d",pokemon.getHeight()));
        tvWeight.setText(String.format("%d",pokemon.getWeight()));
        Glide.with(this).load(pokemon.getSpriteFront()).into(ivPokemon);
    }
}
