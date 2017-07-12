package com.mercari.mercaritest.dagger;

import com.mercari.mercaritest.manager.ProductManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by AmeyJain on 7/11/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(ProductManager manager);
}