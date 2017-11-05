package com.albertgf.pokeapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.BaseComponent;
import com.albertgf.pokeapp.di.components.DaggerBaseComponent;
import com.albertgf.pokeapp.presenter.GenderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenderActivity extends BaseActivity implements GenderPresenter.View {

    @BindView(R.id.act_gender_iv_female) View ivFemale;
    @BindView(R.id.act_gender_iv_male) View ivMale;
    @BindView(R.id.act_gender_btn_start) View btnStart;

    @Inject GenderPresenter presenter;
    private BaseComponent component;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, GenderActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

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

    @OnClick({R.id.act_gender_iv_male, R.id.act_gender_iv_female})
    public void onGenderClick(View view) {
        ivFemale.setSelected(false);
        ivMale.setSelected(false);
        btnStart.setSelected(true);

        switch (view.getId()) {
            case R.id.act_gender_iv_male:
                ivMale.setSelected(true);
                break;
            case R.id.act_gender_iv_female:
                ivFemale.setSelected(true);
        }
    }

    @OnClick(R.id.act_gender_btn_start)
    public void onStartClick() {
        if(btnStart.isSelected()) presenter.setGender(this, ivMale.isSelected());
    }


    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override public void navigateToMain() {
        navigator.navigateToMain(this);
    }
}
