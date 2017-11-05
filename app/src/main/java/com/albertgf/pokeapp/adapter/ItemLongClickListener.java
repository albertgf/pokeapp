package com.albertgf.pokeapp.adapter;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by albertgf on 5/11/17.
 */

public interface ItemLongClickListener<T> {
    boolean onItemLongClick(@NonNull T item, @NonNull DefaultViewHolder<T> viewHolder, @NonNull View view);
}
