package ru.nekit.android.vl_architecture.test.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.nekit.android.vl_architecture.presentation.di.api.BuildingsApiModule;
import ru.nekit.android.vl_architecture.presentation.di.network.NetworkModule;
import ru.nekit.android.vl_architecture.test.BuildingListPresenterTest;
import ru.nekit.android.vl_architecture.test.MockDataTest;
import ru.nekit.android.vl_architecture.test.UseCasesAndMapperTest;
import ru.nekit.android.vl_architecture.test.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.test.di.modules.MockApplicationModule;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
@Singleton
@Component(
        modules = {
                MockApplicationModule.class,
                BuildingsApiModule.class,
                NetworkModule.class,
                BuildingListModule.class
        }
)
public interface MockApplicationComponent {

    void inject(@NonNull MockDataTest value);

    void inject(@NonNull UseCasesAndMapperTest value);

    void inject(@NonNull BuildingListPresenterTest value);

}
