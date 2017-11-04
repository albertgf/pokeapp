package com.albertgf.pokeapp.presenter;

/**
 * Created by albertgf on 4/11/17.
 */

public interface Presenter {
    void onViewAttached(PresenterView view, boolean isNew);
    void onViewDetached();

    interface PresenterView {
        void onError(String text);
    }
}
