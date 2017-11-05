package com.albertgf.pokeapp.presenter;

import android.content.Context;

import com.albertgf.data.datasource.PreferenceSource;
import com.albertgf.pokeapp.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class GenderPresenter implements Presenter {

    private View view;

    @Inject
    public GenderPresenter() {

    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
    }

    @Override public void onViewDetached() {

    }


    public  void setGender(Context context, boolean isMale) {
        PreferenceSource.getInstance(context).setMale(isMale);
        PreferenceSource.getInstance(context).setFirstTime(false);

        view.navigateToMain();
    }

    public interface View extends PresenterView {
        void navigateToMain();
    }
}
