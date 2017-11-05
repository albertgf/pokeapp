package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.presenter.MainPresenter;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @BindView(R.id.act_main_iv_pokemon) ImageView ivPokemon;

    @Inject MainPresenter presenter;
    private BaseComponent component;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initInjector();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onViewAttached(this, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onViewDetached();
    }

    private void initInjector() {
        this.component = DaggerBaseComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        component.inject(this);
    }

    // ********************************************
    // ********** CLICK LISTENERS *****************
    // ********************************************

    @OnClick (R.id.act_main_tv_leave)
    public void onLeaveClick() {
        // TODO presenter.leavePokemon();
    }

    @OnClick (R.id.act_main_tv_catch)
    public void onCatchClick() {
        // TODO presenter.catchPokemon();
    }

    @OnClick (R.id.act_main_tv_search)
    public void onSearchClick() {
        presenter.searchPokemon();
    }

    @OnClick (R.id.act_main_iv_backpack)
    public void onBackpackClick() {
        // TODO navigator.navigateToBackpack();
    }

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override public void bindPokemon(PokemonModelView pokemon) {
        Glide.with(this).load(pokemon.getSprites().getFrontDefault()).into(ivPokemon);
    }
}
