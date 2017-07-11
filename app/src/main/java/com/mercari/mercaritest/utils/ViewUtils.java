package com.mercari.mercaritest.utils;

import android.util.TypedValue;
import android.view.View;

/**
 * Created by Amey on 7/11/17.
 */

public class ViewUtils {

    public static float dipsToPixels(float dips, View view)
    {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dips, view.getResources().getDisplayMetrics());
    }

}
