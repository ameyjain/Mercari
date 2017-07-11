package com.mercari.mercaritest.views;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.mercari.mercaritest.BR;
import com.mercari.mercaritest.data.model.ItemViewModel;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public ProductViewHolder(@NonNull final ViewDataBinding binding) {

        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(ItemViewModel item) {

        binding.setVariable(BR.itemViewModel, item);
        binding.executePendingBindings();

    }
}