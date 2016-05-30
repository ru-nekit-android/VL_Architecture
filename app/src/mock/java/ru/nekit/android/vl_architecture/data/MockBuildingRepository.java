package ru.nekit.android.vl_architecture.data;

import java.util.List;

import ru.nekit.android.vl_architecture.tools.TestUtils;
import ru.nekit.android.vl_architecture.buildingList.data.BuildingDTO;
import ru.nekit.android.vl_architecture.buildingList.data.BuildingDTOToBuildingEntityMapper;
import ru.nekit.android.vl_architecture.buildingList.domain.BuildingEntity;
import ru.nekit.android.vl_architecture.buildingList.domain.IBuildingsRepository;
import rx.Observable;

import static java.util.Arrays.asList;
import static rx.Observable.just;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class MockBuildingRepository implements IBuildingsRepository {

    private TestUtils testUtils;
    private BuildingDTOToBuildingEntityMapper mapper;

    public MockBuildingRepository() {
        testUtils = new TestUtils();
        mapper = new BuildingDTOToBuildingEntityMapper();
    }

    @Override
    public Observable<BuildingEntity> getBuilding(int id) {
        return null;
    }

    @Override
    public Observable<List<BuildingEntity>> getBuildings() {
        return just(asList(testUtils.getGson().fromJson(testUtils.readString("json/builds"), BuildingDTO[].class))).map(mapper);
    }
}
