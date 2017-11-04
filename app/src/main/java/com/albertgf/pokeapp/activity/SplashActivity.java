package com.albertgf.pokeapp.activity;

import android.os.Bundle;
import android.os.Handler;

import com.albertgf.data.datasource.PreferenceSource;
import com.albertgf.pokeapp.R;
import com.albertgf.pokeapp.di.components.ActivityComponent;
import com.albertgf.pokeapp.di.components.DaggerActivityComponent;
import com.albertgf.pokeapp.di.components.DaggerSplashComponent;
import com.albertgf.pokeapp.di.components.SplashComponent;
import com.albertgf.pokeapp.presenter.MainPresenter;
import com.albertgf.pokeapp.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashPresenter.View {

    private static final int TIME_DELAY = 2000;

    @Inject SplashPresenter presenter;
    private SplashComponent component;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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
        this.component = DaggerSplashComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        component.inject(this);
    }

    private void initData() {
        presenter.setFirstLaunch(PreferenceSource.getInstance(this).isFirstTime());
    }

    private Runnable delayRunnable = new Runnable() {

        @Override
        public void run() {
            presenter.manageLaunch();
        }
    };

    // ******************************************
    // ********** VIEW CALLBACK *****************
    // ******************************************

    @Override public void onError(String text) {

    }

    @Override
    public void startLaunch() {
        mHandler.postDelayed(delayRunnable, TIME_DELAY);
    }

    @Override
    public void stopLaunch() {
        mHandler.removeCallbacks(delayRunnable);
    }

    @Override public void navigateToMain() {
        //TODO
    }

    @Override public void navigateToGender() {
        //TODO
    }
}
