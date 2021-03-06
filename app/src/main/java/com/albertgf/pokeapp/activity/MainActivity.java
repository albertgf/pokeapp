package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.presenter.MainPresenter;
import com.albertgf.pokeapp.view.PokemonView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @BindView (R.id.act_main_cv_pokemon) PokemonView cvPokemon;
    @BindView (R.id.act_main_container_action) ViewGroup vgPokemonAction;
    @BindView (R.id.act_main_btn_catch) TextView btnCatch;
    @BindView (R.id.act_main_vg_search) ViewGroup vgSearch;
    @BindView(R.id.act_main_pb) ProgressBar pbLoading;

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
    // ********** PRIVATE METODS *****************
    // ********************************************

    private void showSearch() {
        pbLoading.setVisibility(View.GONE);
        vgSearch.setVisibility(View.VISIBLE);
    }

    // ********************************************
    // ********** CLICK LISTENERS *****************
    // ********************************************

    @OnClick (R.id.act_main_btn_leave)
    public void onLeaveClick() {
        presenter.leavePokemon();
    }

    @OnClick (R.id.act_main_btn_catch)
    public void onCatchClick() {
        presenter.catchPokemon();
    }

    @OnClick (R.id.act_main_btn_search)
    public void onSearchClick() {
        presenter.searchPokemon();
        pbLoading.setVisibility(View.VISIBLE);
        vgSearch.setVisibility(View.GONE);
    }

    @OnClick (R.id.act_main_iv_backpack)
    public void onBackpackClick() {
        navigator.navigateToList(this);
    }

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override public void bindPokemon(PokemonModelView pokemon) {
        pbLoading.setVisibility(View.GONE);
        cvPokemon.setVisibility(View.VISIBLE);
        vgPokemonAction.setVisibility(View.VISIBLE);
        cvPokemon.bindData(pokemon);
        btnCatch.setVisibility(pokemon.isCatched() ? View.GONE : View.VISIBLE);
    }

    @Override public void hidePokemon() {
        showSearch();
        cvPokemon.setVisibility(View.GONE);
        vgPokemonAction.setVisibility(View.GONE);
    }

    @Override public void showNotFoundError() {
        showSearch();
        Toast.makeText(this, "NOT FOUND!!!", Toast.LENGTH_SHORT).show();
    }

    @Override public void showServerError() {
        showSearch();
        Toast.makeText(this, "UUPS THE POKEMON HAS FLED!!!", Toast.LENGTH_SHORT).show();
    }

    @Override public void showCatched() {
        Toast.makeText(this, "CATCHED!!!", Toast.LENGTH_SHORT).show();
        hidePokemon();
    }

}
