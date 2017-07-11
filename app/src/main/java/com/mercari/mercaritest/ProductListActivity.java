package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *
 * Created on Jul 11, 2017
 */
public class ProductListActivity extends AppCompatActivity implements ProductListInteractor {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private ProductListPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        presenter = new ProductListPresenter(this);
    }

    @Override
    protected void onDestroy() {

        presenter.unbind();
        super.onDestroy();

    }

}