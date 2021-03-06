package com.mercari.mercaritest.manager;

import com.mercari.mercaritest.utils.AppHelper;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.net.MercariApi;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 *
 * Created by AmeyJain on 7/11/17.
 */

public class ProductManager {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    @Inject
    MercariApi mercariApi;

    private static ProductManager instance = null;

    private final String FILE_NAME = "all.json";
    /**
     *  I have used behaviorSubject as it can also be used as a cache
     *  and Presenter will subscribe to it, so anytime (and from anywhere) data changes
     *  the presenter gets notified
     */
    private BehaviorSubject<ArrayList<Item>> products = BehaviorSubject.create();

    //==============================================================================================
    // Constuctor methods
    //==============================================================================================

    public static ProductManager getInstance() {

        if (instance == null)
        {
            instance = new ProductManager();
        }
        return instance;
    }

    public ProductManager() {

        AppHelper.getApp().getNetComponent().inject(this);
    }

    //==============================================================================================
    // Class Methods
    //==============================================================================================

    public Observable<ArrayList<Item>> getProductsObservable()
    {
        return products.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
    }

    public void updateProducts()
    {
        mercariApi.getItems(FILE_NAME)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        feed -> {
                            products.onNext(feed.getItems());
                        },
                        throwable -> {

                            products.onError(throwable);

                        });
    }
}
