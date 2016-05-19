package ru.nekit.android.vl_architecture.test.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.nekit.android.vl_architecture.test.MockRepositoryTest;
import ru.nekit.android.vl_architecture.test.di.modules.MockApplicationModule;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
@Singleton
@Component(
        modules = {
                MockApplicationModule.class
        }
)
public interface MockApplicationComponent {

    void inject(@NonNull MockRepositoryTest value);

}
