package ru.nekit.android.vl_architecture;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import ru.nekit.android.vl_architecture.di.ApplicationComponent;
import ru.nekit.android.vl_architecture.di.DaggerApplicationComponent;
import ru.nekit.android.vl_architecture.di.modules.ApplicationModule;
import timber.log.Timber;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
public class VLBuildingsApplication extends Application {

    @NonNull
    private ApplicationComponent applicationComponent;

    @NonNull
    public static VLBuildingsApplication get(@NonNull Context context) {
        return (VLBuildingsApplication) context.getApplicationContext();
    }

    @NonNull
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void onCreate() {
        super.onCreate();

        applicationComponent = prepareApplicationComponent();
        applicationComponent.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private ApplicationComponent prepareApplicationComponent() {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
}
