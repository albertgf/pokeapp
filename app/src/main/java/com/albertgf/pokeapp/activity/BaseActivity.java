package com.albertgf.pokeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.albertgf.pokeapp.PokeApp;
import com.albertgf.pokeapp.di.components.ApplicationComponent;
import com.albertgf.pokeapp.di.modules.ActivityModule;
import com.albertgf.pokeapp.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Inject Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((PokeApp) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
