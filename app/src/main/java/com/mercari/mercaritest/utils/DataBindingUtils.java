package com.mercari.mercaritest.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mercari.mercaritest.R;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Amey on 7/11/17.
 */

public class DataBindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(@NonNull final ImageView view, @NonNull final String imageUrl) {

        int pixels = (int) ViewUtils.dipsToPixels(view.getResources().getDimension(R.dimen.corner_radius), view);

        Glide.with(view.getContext())
                .load(imageUrl)
                .fitCenter()
                .bitmapTransform(new RoundedCornersTransformation(view.getContext(), pixels, pixels))
                .into(view);

    }
}
