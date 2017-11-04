package com.albertgf.pokeapp.presenter;

import com.albertgf.pokeapp.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class SplashPresenter implements Presenter {

    private View view;

    private boolean isFirstLaunch = false;

    @Inject
    public SplashPresenter() {

    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;

        this.view.startLaunch();
    }

    @Override public void onViewDetached() {
        view.stopLaunch();
    }

    public void setFirstLaunch(boolean isFirstLaunch) {
        this.isFirstLaunch = isFirstLaunch;
    }

    public void manageLaunch() {
        if (isFirstLaunch) {
            view.navigateToGender();
        } else {
            view.navigateToMain();
        }
    }

    public interface View extends PresenterView {
        void startLaunch();

        void stopLaunch();

        void navigateToMain();

        void navigateToGender();
    }
}
