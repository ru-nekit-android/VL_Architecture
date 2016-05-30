package ru.nekit.android.vl_architecture.domain.buildingList;

import android.support.annotation.NonNull;

import java.util.List;

import ru.nekit.android.vl_architecture.cleanArchitecture.interactors.IParameterlessInteractor;
import rx.Observable;
import rx.Subscription;
import rx.subjects.ReplaySubject;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
public class RequestBuildingListUseCase implements IParameterlessInteractor<List<BuildingEntity>> {

    private final IBuildingsRepository mRepository;
    private ReplaySubject<List<BuildingEntity>> mDelegateSubject;
    private Subscription mDelegateSubscription;

    public RequestBuildingListUseCase(@NonNull IBuildingsRepository repository) {
        mRepository = repository;
    }

    @NonNull
    public Observable<List<BuildingEntity>> execute() {
        if (mDelegateSubscription == null || mDelegateSubscription.isUnsubscribed()) {
            mDelegateSubject = ReplaySubject.create();
            mDelegateSubscription = mRepository.getBuildings().subscribe(mDelegateSubject);
        }
        return mDelegateSubject.asObservable();
    }
}
