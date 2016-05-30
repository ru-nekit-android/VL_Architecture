package ru.nekit.android.vl_architecture.presentation.common.activity;

import android.support.annotation.NonNull;

import ru.nekit.android.vl_architecture.VLBuildingsApplication;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.activity.MVPActivity;
import ru.nekit.android.vl_architecture.presentation.di.ApplicationComponent;

/**
 * Created by ru.nekit.android on 15.04.16.
 */
public class BaseActivity<C> extends MVPActivity<C> {

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return VLBuildingsApplication.get(getApplicationContext()).getApplicationComponent();
    }

}
