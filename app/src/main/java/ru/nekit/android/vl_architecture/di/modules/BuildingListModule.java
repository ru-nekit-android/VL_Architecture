package ru.nekit.android.vl_architecture.di.modules;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.nekit.android.vl_architecture.buildingList.domain.IBuildingsRepository;
import ru.nekit.android.vl_architecture.buildingList.domain.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingListViewModel;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.IBuildingListViewModel;
import ru.nekit.android.vl_architecture.di.scopes.BuildingListScope;

/**
 * Created by ru.nekit.android on 08.03.16.
 */

@Module
@BuildingListScope
public class BuildingListModule {

    @Provides
    @NonNull
    public RequestBuildingListUseCase provideRequestBuildingListUseCase(IBuildingsRepository repository) {
        return new RequestBuildingListUseCase(repository);
    }

    @Provides
    @NonNull
    public IBuildingListViewModel provideIBuildingListViewModel() {
        return new BuildingListViewModel();
    }

}
