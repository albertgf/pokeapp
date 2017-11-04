package com.albertgf.data.datasource;

import android.content.Context;

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
}
