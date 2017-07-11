package com.mercari.mercaritest.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Amey on 7/11/17.
 */

public class PriceUtils
{
    public static String formatPrice(double price)
    {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }
}
