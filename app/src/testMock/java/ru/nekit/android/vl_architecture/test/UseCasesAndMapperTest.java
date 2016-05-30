package ru.nekit.android.vl_architecture.test;

import android.support.annotation.NonNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import ru.nekit.android.vl_architecture.domain.buildingList.BuildingEntity;
import ru.nekit.android.vl_architecture.domain.buildingList.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingListViewModel;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingEntityToItemVOMapper;
import ru.nekit.android.vl_architecture.test.di.DaggerMockApplicationComponent;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
public class UseCasesAndMapperTest {

    /**
     * Initialized in {@link #requestBuildingListUseCaseTest} and {@link #mapperTest}.
     */
    @Inject
    @SuppressWarnings("NullableProblems")
    @NonNull
    protected RequestBuildingListUseCase interactor;

    /**
     * Initialized in {@link #mapperTest}.
     */
    @Inject
    @SuppressWarnings("NullableProblems")
    @NonNull
    protected BuildingEntityToItemVOMapper mapper;

    @Before
    public void setUp() {
        DaggerMockApplicationComponent.create().inject(this);
    }

    @Test
    public void requestBuildingListUseCaseTest() {
        TestSubscriber<List<BuildingEntity>> subscriber = new TestSubscriber<>();
        interactor.execute().subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        List<BuildingEntity> actual = subscriber.getOnNextEvents().get(0);
        Assert.assertNotNull(actual);
        assertEquals(4, actual.size());
    }

    @Test
    public void mapperTest() {
        TestSubscriber<BuildingListViewModel> subscriber = new TestSubscriber<>();
        interactor.execute().map(mapper).map(BuildingListViewModel::new).subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        BuildingListViewModel actual = subscriber.getOnNextEvents().get(0);
        Assert.assertNotNull(actual);
        assertEquals(4, actual.size());

    }

}
