package ru.nekit.android.vl_architecture.model;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements IImageLoader {

    @NonNull
    private final Picasso picasso;

    public PicassoImageLoader(@NonNull final Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void downloadInto(@NonNull String url, @NonNull ImageView imageView) {
        picasso.load(url).fit().centerCrop().into(imageView);
    }
}
