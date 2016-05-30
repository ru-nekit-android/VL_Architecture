package ru.nekit.android.vl_architecture.presentation.di.api;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ru.nekit.android.vl_architecture.data.api.BuildingListApi;

/**
 * Created by ru.nekit.android on 02.03.16.
 */
@Module
@Singleton
public class BuildingsApiModule {

    @Provides
    @NonNull
    public BuildingListApi provideApi(@NonNull Retrofit retrofit) {
        return retrofit.create(BuildingListApi.class);
    }

}
