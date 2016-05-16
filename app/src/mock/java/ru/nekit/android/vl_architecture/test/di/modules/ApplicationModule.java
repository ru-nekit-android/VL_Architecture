package ru.nekit.android.vl_architecture.test.di.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nekit.android.vl_architecture.domain.repository.IBuildingsRepository;
import ru.nekit.android.vl_architecture.test.data.MockBuildingRepository;

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
        return new MockBuildingRepository();
    }

}
