package ru.nekit.android.vl_architecture.domain.buildingList;

import java.util.List;

import rx.Observable;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public interface IBuildingsRepository {

    Observable<BuildingEntity> getBuilding(int id);

    Observable<List<BuildingEntity>> getBuildings();

}
