package ru.nekit.android.vl_architecture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import ru.nekit.android.vl_architecture.data.buildingList.BuildingDTO;
import ru.nekit.android.vl_architecture.data.buildingList.BuildingDTOToBuildingEntityMapper;
import ru.nekit.android.vl_architecture.domain.buildingList.BuildingEntity;
import ru.nekit.android.vl_architecture.domain.buildingList.IBuildingsRepository;
import ru.nekit.android.vl_architecture.tools.TestUtils;
import rx.Observable;
import rx.observers.TestSubscriber;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static rx.Observable.just;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildingEntityRepositoryTest {

    protected final TestUtils testUtils = new TestUtils();

    @Mock
    private IBuildingsRepository repository;

    public Observable<List<BuildingDTO>> provideBuildingListObservable() {
        return just(asList(testUtils.getGson().fromJson(testUtils.readString("json/builds"), BuildingDTO[].class)));
    }

    @Test
    public void obtainRawTest() {
        String builds = testUtils.readString("json/builds");
        assertNotNull(builds);
        assertTrue(builds.length() > 0);
    }

    @Test
    public void obtainObservableTest() {
        List<BuildingDTO> builds = asList(testUtils.getGson().fromJson(testUtils.readString("json/builds"), BuildingDTO[].class));
        assertNotNull(builds);
        assertTrue(builds.size() == 4);
        assertNotNull(builds.get(0));
        assertNotNull(builds.get(0).getImages());
        assertTrue(builds.get(0).getImages().size() == 3);
    }

    @Test
    public void mapperTest() {

        TestSubscriber<List<BuildingDTO>> subscriberDTOList = new TestSubscriber<>();
        provideBuildingListObservable().subscribe(subscriberDTOList);

        TestSubscriber<List<BuildingEntity>> subscriberEntityList = new TestSubscriber<>();
        provideBuildingListObservable().map(new BuildingDTOToBuildingEntityMapper()).subscribe(subscriberEntityList);

        subscriberEntityList.assertNoErrors();
        subscriberEntityList.assertValueCount(1);
        subscriberEntityList.assertCompleted();

        List<BuildingEntity> actualEntity = subscriberEntityList.getOnNextEvents().get(0);
        assertNotNull(actualEntity);
        assertEquals(4, actualEntity.size());
        BuildingEntity actualEntityItem = actualEntity.get(0);

        List<BuildingDTO> actualDTO = subscriberDTOList.getOnNextEvents().get(0);
        assertNotNull(actualDTO);
        assertEquals(4, actualDTO.size());

        BuildingDTO actualDTOItem = actualDTO.get(0);
        assertEquals(actualEntityItem.getId(), Integer.parseInt(actualDTOItem.getId()));
        assertEquals(actualEntityItem.getAuthor(), actualDTOItem.getAuthor());
        assertEquals(actualEntityItem.getDescription(), actualDTOItem.getDescription());
        assertEquals(actualEntityItem.getName(), actualDTOItem.getName());
        assertEquals(actualEntityItem.getImages().size(), actualDTOItem.getImages().size());
        assertEquals(actualEntityItem.getImages().get(0).getDescription(), actualDTOItem.getImages().get(0).getDescription());
        assertEquals(actualEntityItem.getImages().get(0).getCaption(), actualDTOItem.getImages().get(0).getCaption());
        assertEquals(actualEntityItem.getImages().get(0).getUrl(), actualDTOItem.getImages().get(0).getUrl());
    }

    @Test
    public void repositoryTest() {
        when(repository.getBuildings()).thenReturn(provideBuildingListObservable().map(new BuildingDTOToBuildingEntityMapper()));
        TestSubscriber<List<BuildingEntity>> subscriberEntity = new TestSubscriber<>();
        repository.getBuildings().subscribe(subscriberEntity);
        List<BuildingEntity> actualEntity = subscriberEntity.getOnNextEvents().get(0);
        assertNotNull(actualEntity);
        assertEquals(4, actualEntity.size());
        BuildingEntity actualEntityItem = actualEntity.get(0);
        assertNotNull(actualEntityItem);
        verify(repository).getBuildings();
    }

}
