package com.mercari.mercaritest.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Amey on 7/11/17.
 */

public enum Status {

    @SerializedName("on_sale")
    ON_SALE,

    @SerializedName("sold_out")
    SOLD_OUT
}