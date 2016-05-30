package ru.nekit.android.vl_architecture.di.network.qualifier;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
public @interface OkHttpNetworkInterceptors {
}
