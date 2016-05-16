package ru.nekit.android.vl_architecture.di.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nekit.android.vl_architecture.domain.repository.IBuildingsRepository;

/**
 * Created by ru.nekit.android on 29.03.16.
 */
@Module
@Singleton
public class ApplicationModule {

    @NonNull
    private final Application application;

    public ApplicationModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @NonNull
    public Application provideApplication() {
        return application;
    }

    @Provides
    @NonNull
    public IBuildingsRepository provideRepository() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
