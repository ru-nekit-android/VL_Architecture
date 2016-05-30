package ru.nekit.android.vl_architecture.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import ru.nekit.android.vl_architecture.buildingList.data.BuildingDTO;
import ru.nekit.android.vl_architecture.buildingList.data.BuildingDTOToBuildingEntityMapper;
import ru.nekit.android.vl_architecture.buildingList.domain.BuildingEntity;
import ru.nekit.android.vl_architecture.buildingList.domain.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.buildingList.presentation.BuildingListPresenter;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingEntityToItemVOMapper;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingItemVO;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingListViewModel;
import ru.nekit.android.vl_architecture.buildingList.presentation.view.IBuildingListView;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.PresenterLifeCircleDelegate;
import ru.nekit.android.vl_architecture.tools.TestUtils;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static rx.Observable.just;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildingListPresenterTest {

    protected final TestUtils testUtils = new TestUtils();
    @Mock
    BuildingListViewModel model;
    @Mock
    RequestBuildingListUseCase interactor;
    @Mock
    BuildingEntityToItemVOMapper mapper;
    @Mock
    IBuildingListView view;

    private BuildingListPresenter target;
    private PresenterLifeCircleDelegate<BuildingListPresenter> targetLifeCircleDelegate;

    @Before
    public void setUp() {
        target = new BuildingListPresenter(model, interactor, mapper);
        targetLifeCircleDelegate = new PresenterLifeCircleDelegate<>();
    }

    public List<BuildingItemVO> getBuildingItemVOs() {
        return just(asList(testUtils.getGson()
                .fromJson(testUtils.readString("json/builds"), BuildingDTO[].class)))
                .map(new BuildingDTOToBuildingEntityMapper())
                .map(new BuildingEntityToItemVOMapper())
                .toBlocking().first();
    }

    @Test
    public void onCreateWithPostponedAttachViewTest() {
        List<BuildingEntity> stubResult = new ArrayList<>();
        when(mapper.call(stubResult)).thenReturn(getBuildingItemVOs());
        when(interactor.execute()).thenReturn(just(stubResult));
        targetLifeCircleDelegate.onCreate(target, null);
        targetLifeCircleDelegate.onCreateView(view, null);
        verify(view).hideLoading();
        verify(view).showContent(model);

    }

    @After
    public void tearDown() {

    }
}
