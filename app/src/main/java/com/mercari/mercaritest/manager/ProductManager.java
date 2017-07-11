package com.mercari.mercaritest.manager;

import android.content.Context;

import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.net.MercariApi;
import com.mercari.mercaritest.net.MercariServices;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 *
 * Manager is an mediator that separates View code and Network code
 *
 * Created by AmeyJain on 7/11/17.
 */

public class ProductManager {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private static final String FILE_NAME = "all.json";
    /**
     *  I have used behaviorSubject as it can also be used as a cache
     *  and Presenter will subscribe to it, so anytime (and from anywhere) data changes
     *  the presenter gets notified
     */
    private static BehaviorSubject<ArrayList<Item>> products = BehaviorSubject.create();

    //==============================================================================================
    // Class Methods
    //==============================================================================================

    public static Observable<ArrayList<Item>> getProductsObservable()
    {
        return products.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
    }

    public static void updateProducts(Context context)
    {
        MercariServices.getInstance(context)
                .getItems(FILE_NAME)
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
