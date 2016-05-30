package ru.nekit.android.vl_architecture.ui.activity;

import android.support.annotation.NonNull;

import ru.nekit.android.vl_architecture.VLBuildingsApplication;
import ru.nekit.android.vl_architecture.di.ApplicationComponent;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.activity.MVPActivity;

/**
 * Created by ru.nekit.android on 15.04.16.
 */
public class BaseActivity<C> extends MVPActivity<C> {

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return VLBuildingsApplication.get(getApplicationContext()).getApplicationComponent();
    }

}
