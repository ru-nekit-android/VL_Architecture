package ru.nekit.android.vl_architecture.cleanArchitecture.interactors;

import rx.Observable;

/**
 * Created by ru.nekit.android on 10.03.16.
 */
public interface IParameterlessInteractor<R> {

    Observable<R> execute();

}
