package com.albertgf.data.datasource;

import android.content.Context;

import com.albertgf.data.mapper.DiskMapper;
import com.albertgf.data.mapper.PokemonDataMapper;
import com.albertgf.data.model.PokemonDisk;
import com.albertgf.domain.model.PokemonModelView;

import io.realm.Realm;

/**
 * Created by albertgf on 4/11/17.
 */

public class DiskDataSourceImpl implements DiskDataSource{
    private final Context context;
    private final Realm realm;

    public DiskDataSourceImpl(Context context) {
        this.context = context;
        this.realm = Realm.getDefaultInstance();
        realm.refresh();
    }

    @Override public Context getContext() {
        return context;
    }

    @Override public void closeDisk() {
        if (realm != null) {
            realm.close();
        }
    }

    @Override public void savePokemon(PokemonModelView pokemon) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(DiskMapper.buildHealthInfoDiskModel(pokemon));
        realm.commitTransaction();
    }

    @Override public PokemonDisk getPokemon(int id) {
        return realm.where(PokemonDisk.class).equalTo("id", id).findFirst();
    }
}
