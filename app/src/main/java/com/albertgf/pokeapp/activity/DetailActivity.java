package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.albertgf.pokeapp.presenter.DetailPresenter;
import com.albertgf.pokeapp.presenter.ListPresenter;
import com.albertgf.pokeapp.view.PokemonView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailPresenter.View {

    @BindView(R.id.act_detail_cv_pokemon) PokemonView cvPokemon;
    @BindView(R.id.act_detail_tv_exp) TextView tvExperience;
    @BindView(R.id.act_detail_vg_type) LinearLayout vgType;

    @Inject DetailPresenter presenter;
    private BaseComponent component;

    public static Intent getCallingIntent(Context context, int id, String transitionName, String url) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("transition", transitionName);
        intent.putExtra("url", url);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        initInjector();
        initData();
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

    private void initData() {
        presenter.setPokemonId(getIntent().getExtras().getInt("id"));

        initTransition(getIntent().getExtras().getString("url"), getIntent().getExtras().getString("transition"));
    }

    private void initTransition(String url, String transitionName) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cvPokemon.ivPokemon.setTransitionName(transitionName);
        }

        Glide.with(this).load(url).listener(new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target,
                                        boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target,
                                           DataSource dataSource, boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }
        }).into(cvPokemon.ivPokemon);


    }

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }
    @Override public void bindPokemon(PokemonModelView pokemon) {
        cvPokemon.bindData(pokemon);
        tvExperience.setText(String.format("%d", pokemon.getBaseExperience()));
        vgType.removeAllViews();

        for(String type : pokemon.getTypes()) {
            TextView view = new TextView(this);
            view.setText(type);
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            vgType.addView(view);
        }
    }
}
