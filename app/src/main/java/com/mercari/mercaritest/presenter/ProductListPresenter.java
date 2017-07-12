package com.mercari.mercaritest.presenter;

import com.mercari.mercaritest.manager.ProductManager;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.interactor.ProductListInteractor;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 *
 * Created on Jul 11, 2017
 */
public class ProductListPresenter {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    ProductListInteractor view;
    private Disposable subscription;

    public ProductListPresenter(ProductListInteractor view) {
        this.view = view;
        init();
    }

    //==============================================================================================
    // Instance methods
    //==============================================================================================

    private void init() {

        subscription = ProductManager.getInstance().getProductsObservable()
                .subscribeWith(new DisposableObserver<ArrayList<Item>>() {
                    @Override
                    public void onNext(ArrayList<Item> items) {

                        if (view != null) {
                            view.showProducts(items);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showGenericError();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getProducts()
    {
        ProductManager.getInstance().updateProducts();
    }

    public void unbind() {
        this.view = null;
        subscription.dispose();
    }

}