package com.mercari.mercaritest.interactor;

import android.os.Bundle;

import com.mercari.mercaritest.data.model.Item;

import java.util.ArrayList;

/**
 *
 * Created on Jul 11, 2017
 */
public interface ProductListInteractor {

    void showProducts(ArrayList<Item> items);

    void showGenericError();
}