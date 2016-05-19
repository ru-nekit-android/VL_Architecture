package ru.nekit.android.vl_architecture.test;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import ru.nekit.android.vl_architecture.domain.entity.BuildingEntity;
import ru.nekit.android.vl_architecture.domain.repository.IBuildingsRepository;
import ru.nekit.android.vl_architecture.test.di.DaggerMockApplicationComponent;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class MockRepositoryTest {

    @Inject
    @SuppressWarnings("NullableProblems") // Initialized in @Before.
    @NonNull
    protected IBuildingsRepository repository;

    @Before
    public void setup() {
        DaggerMockApplicationComponent.create().inject(this);
    }

    @Test
    public void test() {

        TestSubscriber<List<BuildingEntity>> subscriber = new TestSubscriber<>();
        repository.getAllBuildings().subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        List<BuildingEntity> actualEntities = subscriber.getOnNextEvents().get(0);
        assertNotNull(actualEntities);
        //TODO: change value in future after change builds.json
        assertEquals(1, actualEntities.size());
        BuildingEntity actualEntity = actualEntities.get(0);
        assertNotNull(actualEntity);

    }
}
