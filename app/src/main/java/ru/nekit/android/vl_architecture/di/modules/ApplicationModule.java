package ru.nekit.android.vl_architecture.di.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import ru.nekit.android.vl_architecture.model.IImageLoader;
import ru.nekit.android.vl_architecture.model.PicassoImageLoader;
import ru.nekit.android.vl_architecture.buildingList.domain.IBuildingsRepository;
import ru.nekit.android.vl_architecture.data.MockBuildingRepository;

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

    @Provides
    @NonNull
    public Picasso providePicasso(@NonNull Application application, @NonNull OkHttpClient okHttpClient) {
        return new Picasso.Builder(application)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

    @Provides
    @NonNull
    public IImageLoader provideImageLoader(@NonNull Picasso picasso) {
        return new PicassoImageLoader(picasso);
    }
}
