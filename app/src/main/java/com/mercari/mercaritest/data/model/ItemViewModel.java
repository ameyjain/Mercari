package com.mercari.mercaritest.data.model;

import android.databinding.Bindable;
import android.view.View;

import com.mercari.mercaritest.utils.PriceUtils;

/**
 * Created by AmeyJain on 7/11/17.
 */

public class ItemViewModel {

    //==============================================================================================
    // Class properties
    //==============================================================================================

    private Item item;

    //==============================================================================================
    // Constructor
    //==============================================================================================

    public ItemViewModel(Item item) {
        this.item = item;
    }

    //==============================================================================================
    // Binding methods
    //==============================================================================================

    @Bindable
    public String getName() {
        return item.getName();
    }

    @Bindable
    public String getPrice() {
        return PriceUtils.formatPrice(item.getPrice());
    }

    @Bindable
    public String getPhoto() {
        return item.getPhoto();
    }

    @Bindable
    public int getSoldOutVisibility() {
        return item.getStatus() == Status.SOLD_OUT ? View.VISIBLE : View.GONE;
    }

}
