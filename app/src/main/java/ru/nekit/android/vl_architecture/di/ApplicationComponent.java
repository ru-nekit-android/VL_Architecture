package ru.nekit.android.vl_architecture.di;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.nekit.android.vl_architecture.di.modules.ApplicationModule;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

    void inject(@NonNull Application value);

}
