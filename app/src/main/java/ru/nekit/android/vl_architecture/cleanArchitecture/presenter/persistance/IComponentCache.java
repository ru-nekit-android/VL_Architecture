package ru.nekit.android.vl_architecture.cleanArchitecture.presenter.persistance;

public interface IComponentCache<C> {
    int generateId();

    C getComponent(int index);

    void setComponent(int index, C component);
}
