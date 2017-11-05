package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.presenter.ListPresenter;
import com.albertgf.pokeapp.presenter.MainPresenter;
import com.albertgf.pokeapp.view.PokemonView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends BaseActivity implements ListPresenter.View {

    @Inject ListPresenter presenter;
    private BaseComponent component;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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



    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override public void bindPokemons(List<PokemonModelView> list) {
        Toast.makeText(this, "list: " + list.size(), Toast.LENGTH_SHORT).show();
    }
}
