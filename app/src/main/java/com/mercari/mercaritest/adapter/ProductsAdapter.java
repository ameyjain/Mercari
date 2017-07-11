package com.mercari.mercaritest.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.data.model.ItemViewModel;
import com.mercari.mercaritest.views.ProductViewHolder;

import java.util.List;

/**
 * Created by AmeyJain on 7/11/17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    private List<Item> items;

    //==============================================================================================
    // Constructor
    //==============================================================================================

    public ProductsAdapter(List<Item> items) {
        this.items = items;
    }

    //==============================================================================================
    // Instance methods
    //==============================================================================================

    public void setData(List<Item> items)
    {
        this.items = items;
        notifyDataSetChanged();
    }

    //==============================================================================================
    // Adapter Implementation
    //==============================================================================================

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new ProductViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        holder.bind(new ItemViewModel(items.get(position)));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @LayoutRes
    @Override
    public int getItemViewType(final int position) {
        return R.layout.view_list_item;
    }

}
