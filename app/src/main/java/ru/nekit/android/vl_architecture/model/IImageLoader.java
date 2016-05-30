package ru.nekit.android.vl_architecture.model;

import android.support.annotation.NonNull;
import android.widget.ImageView;

public interface IImageLoader {
    void downloadInto(@NonNull String url, @NonNull ImageView imageView);
}