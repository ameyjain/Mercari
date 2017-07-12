package com.mercari.mercaritest.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mercari.mercaritest.interactor.ProductListInteractor;
import com.mercari.mercaritest.presenter.ProductListPresenter;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.adapter.ProductsAdapter;
import com.mercari.mercaritest.data.model.Item;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created on Jul 11, 2017
 */
public class ProductListActivity extends AppCompatActivity
        implements ProductListInteractor, SwipeRefreshLayout.OnRefreshListener  {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    @BindView(R.id.home_item_recycler_view)
    RecyclerView homeItemRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ProductListPresenter presenter;
    private ProductsAdapter allItemsAdapter;

    //==============================================================================================
    // Lifecycle Methods
    //==============================================================================================

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        setupRecyclerView();
        presenter = new ProductListPresenter(this);
        presenter.getProducts();
    }

    @Override
    protected void onDestroy() {

        presenter.unbind();
        super.onDestroy();
    }

    //==============================================================================================
    // Instance methods
    //==============================================================================================

    private void setupRecyclerView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        allItemsAdapter = new ProductsAdapter(Collections.emptyList());
        swipeRefreshLayout.setRefreshing(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        homeItemRecyclerView.setAdapter(allItemsAdapter);
        homeItemRecyclerView.setLayoutManager(layoutManager);
    }

    //==============================================================================================
    // OnRefreshListener Implementation
    //==============================================================================================

    @Override
    public void onRefresh() {
        presenter.getProducts();
    }

    @Override
    public void showProducts(ArrayList<Item> items) {

        swipeRefreshLayout.setRefreshing(false);
        allItemsAdapter.setData(items);
    }

    @Override
    public void showGenericError() {

        Toast.makeText(this, "Failed to bind data", Toast.LENGTH_LONG).show();
    }
}