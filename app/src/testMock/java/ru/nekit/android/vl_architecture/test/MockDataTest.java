package ru.nekit.android.vl_architecture.test;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import ru.nekit.android.vl_architecture.data.api.BuildingListApi;
import ru.nekit.android.vl_architecture.data.buildingList.BuildingDTO;
import ru.nekit.android.vl_architecture.domain.buildingList.BuildingEntity;
import ru.nekit.android.vl_architecture.domain.buildingList.IBuildingsRepository;
import ru.nekit.android.vl_architecture.presentation.di.api.BuildingsApiModule;
import ru.nekit.android.vl_architecture.presentation.di.network.NetworkModule;
import ru.nekit.android.vl_architecture.test.di.DaggerMockApplicationComponent;
import ru.nekit.android.vl_architecture.tools.TestUtils;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class MockDataTest {

    @Inject
    @SuppressWarnings("NullableProblems") /* Initialized in repositoryTest. */
    @NonNull
    protected IBuildingsRepository repository;

    @Test
    public void apiTest() {
        MockWebServer mockWebServer = new MockWebServer();
        try {
            mockWebServer.start();
        } catch (IOException error) {
            //empty
        }
        final TestUtils testUtils = new TestUtils();
        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                String path = request.getPath();
                if (path.equals("/buildings/")) {
                    return new MockResponse().setResponseCode(200).setBody(testUtils.readString("json/builds"));
                }
                return new MockResponse().setResponseCode(404);
            }
        };
        mockWebServer.setDispatcher(dispatcher);
        HttpUrl baseUrl = mockWebServer.url("/");

        NetworkModule networkModule = new NetworkModule();
        BuildingListApi api = new BuildingsApiModule().provideApi(
                networkModule.provideRetrofit(
                        networkModule.provideOkHttpClient(
                                Collections.<Interceptor>emptyList(),
                                Collections.<Interceptor>emptyList()),
                        baseUrl.toString()
                ));

        TestSubscriber<List<BuildingDTO>> subscriber = new TestSubscriber<>();
        api.getBuildings().subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        List<BuildingDTO> buildingDTOs = subscriber.getOnNextEvents().get(0);
        assertNotNull(buildingDTOs);
        assertEquals(4, buildingDTOs.size());
        BuildingDTO buildingDTO = buildingDTOs.get(0);
        assertNotNull(buildingDTO);

        try {
            mockWebServer.shutdown();
        } catch (IOException exception) {
            //no-op
        }

    }

    @Test
    public void repositoryTest() {
        DaggerMockApplicationComponent.create().inject(this);

        TestSubscriber<List<BuildingEntity>> subscriber = new TestSubscriber<>();
        repository.getBuildings().subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        List<BuildingEntity> buildingEntities = subscriber.getOnNextEvents().get(0);
        assertNotNull(buildingEntities);
        assertEquals(4, buildingEntities.size());
        BuildingEntity buildingDTO = buildingEntities.get(0);
        assertNotNull(buildingDTO);
    }
}
