package com.albertgf.data.datasource;

import android.content.Context;

/**
 * Created by albertgf on 4/11/17.
 */

public interface DiskDataSource {
    Context getContext();
    void closeDisk();
}
