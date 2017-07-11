package com.mercari.mercaritest;

/**
 *
 * Created on Jul 11, 2017
 */
public class ProductListPresenter {
    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private ProductListInteractor view;

    public ProductListPresenter(ProductListInteractor view) {
        this.view = view;
    }

    public void unbind() {
        this.view = null;
    }

}