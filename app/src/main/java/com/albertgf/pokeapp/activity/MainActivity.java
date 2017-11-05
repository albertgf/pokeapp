package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.presenter.GenderPresenter;
import com.albertgf.pokeapp.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    private static final int TIME_DELAY = 2000;

    @BindView(R.id.act_gender_iv_female) View ivFemale;
    @BindView(R.id.act_gender_iv_male) View ivMale;
    @BindView(R.id.act_gender_btn_start) View btnStart;

    @Inject GenderPresenter presenter;
    private BaseComponent component;

    private Handler mHandler = new Handler();

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @OnClick(R.id.act_main_tv_leave)
    public void onLeaveClick() {
        // TODO presenter.leavePokemon();
    }

    @OnClick(R.id.act_main_tv_catch)
    public void onCatchClick() {
        // TODO presenter.catchPokemon();
    }

    @OnClick(R.id.act_main_tv_search)
    public void onSearchClick() {
        // TODO presenter.searchPokemon();
    }

    @OnClick(R.id.act_main_iv_backpack)
    public void onBackpackClick() {
        // TODO navigator.navigateToBackpack();
    }

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }
}
