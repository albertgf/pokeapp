package com.albertgf.pokeapp;

import android.app.Application;

import com.albertgf.pokeapp.di.components.ApplicationComponent;
import com.albertgf.pokeapp.di.components.DaggerApplicationComponent;
import com.albertgf.pokeapp.di.modules.ApplicationModule;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by albertgf on 4/11/17.
 */

public class PokeApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        // DI
        this.initializeInjector();

        //REALM
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("default_config")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(
                        new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
