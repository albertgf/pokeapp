package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.adapter.DefaultAdapter;
import com.albertgf.pokeapp.adapter.DefaultViewHolder;
import com.albertgf.pokeapp.adapter.ItemClickListener;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.holder.PokemonHolder;
import com.albertgf.pokeapp.presenter.ListPresenter;
import com.albertgf.pokeapp.presenter.MainPresenter;
import com.albertgf.pokeapp.view.PokemonView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends BaseActivity implements ListPresenter.View, ItemClickListener<PokemonModelView> {

    @BindView(R.id.rvPokemons) RecyclerView rvPokemons;
    @BindView(R.id.act_list_tv_empty) TextView tvEmpty;

    @Inject ListPresenter presenter;
    private BaseComponent component;
    private DefaultAdapter<PokemonModelView> adapter;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        initInjector();
        initRecyclerView();
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

    private void initRecyclerView() {
        adapter = new DefaultAdapter<PokemonModelView>(this,
                new DefaultAdapter.CreateViewHolder<PokemonModelView>() {
                    @NonNull
                    @Override
                    protected DefaultViewHolder<PokemonModelView> onCreateViewHolder(
                            ViewGroup parent,
                            int viewType) {
                        LayoutInflater inflater = LayoutInflater.from(ListActivity.this);
                        View view= inflater.inflate(R.layout.cell_view_pokemon, null, false);
                        return new PokemonHolder(view);
                    }
                });
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rvPokemons.setLayoutManager(layoutManager);
        rvPokemons.setAdapter(adapter);
    }

    // ********************************************
    // ********** CLICK LISTENERS *****************
    // ********************************************

    @Override public void onItemClick(@NonNull PokemonModelView item,
                                      @NonNull DefaultViewHolder<PokemonModelView> viewHolder, @NonNull View view) {
       navigator.navigateToDetail(this, item.getId(), item.getSpriteFront());
    }

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override public void bindPokemons(List<PokemonModelView> list) {
        tvEmpty.setVisibility(list.size() <= 0 ? View.VISIBLE : View.GONE);
        adapter.clear();
        adapter.addItems(list);
        adapter.notifyDataSetChanged();
    }
}
