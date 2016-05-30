package ru.nekit.android.vl_architecture.test.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nekit.android.vl_architecture.buildingList.domain.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.buildingList.domain.IBuildingsRepository;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingEntityToItemVOMapper;

/**
 * Created by ru.nekit.android on 08.03.16.
 */

@Module
@Singleton
public class BuildingListModule {

    @Provides
    @NonNull
    public RequestBuildingListUseCase provideRequestBuildingListUseCase(IBuildingsRepository repository) {
        return new RequestBuildingListUseCase(repository);
    }

    @Provides
    @NonNull
    public BuildingEntityToItemVOMapper provideBuildingEntityToBuildingListModel() {
        return new BuildingEntityToItemVOMapper();
    }

}
