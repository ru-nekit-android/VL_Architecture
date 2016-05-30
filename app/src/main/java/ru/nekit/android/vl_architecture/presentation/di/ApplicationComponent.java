package ru.nekit.android.vl_architecture.presentation.di;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.nekit.android.vl_architecture.presentation.di.api.BuildingsApiModule;
import ru.nekit.android.vl_architecture.presentation.di.modules.ApplicationModule;
import ru.nekit.android.vl_architecture.presentation.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.presentation.di.network.NetworkModule;
import ru.nekit.android.vl_architecture.presentation.di.network.OkHttpInterceptorsModule;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                BuildingsApiModule.class,
                NetworkModule.class,
                OkHttpInterceptorsModule.class
        }
)
public interface ApplicationComponent {

    void inject(@NonNull Application value);

    @NonNull
    BuildingListComponent plus(@NonNull BuildingListModule module);

}
