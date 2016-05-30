package ru.nekit.android.vl_architecture.cleanArchitecture.mapper;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ru.nekit.android on 04.03.16.
 */
public abstract class BaseMapper<P, R> implements Func1<List<P>, List<R>> {
    @Override
    @NonNull
    public List<R> call(@NonNull List<P> inList) {
        return Observable.from(inList)
                .map(this::convert)
                .toList()
                .toBlocking()
                .first();
    }

    @NonNull
    protected abstract R convert(P value);

}
