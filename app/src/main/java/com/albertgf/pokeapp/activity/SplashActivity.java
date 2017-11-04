package com.albertgf.pokeapp.activity;

import android.os.Bundle;

import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.ActivityComponent;
import com.albertgf.pokeapp.di.components.DaggerActivityComponent;
import com.albertgf.pokeapp.di.components.DaggerSplashComponent;
import com.albertgf.pokeapp.di.components.SplashComponent;
import com.albertgf.pokeapp.presenter.MainPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements MainPresenter.View {
    @Inject MainPresenter presenter;
    private SplashComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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
        this.component = DaggerSplashComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        component.inject(this);
    }

    @Override public void onError(String text) {

    }
}
