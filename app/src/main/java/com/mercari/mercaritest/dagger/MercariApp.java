package com.mercari.mercaritest.dagger;

import android.app.Application;

import com.mercari.mercaritest.dagger.AppComponent;
import com.mercari.mercaritest.utils.AppHelper;
import com.mercari.mercaritest.dagger.AppModule;
import com.mercari.mercaritest.dagger.DaggerNetComponent;
import com.mercari.mercaritest.dagger.NetComponent;
import com.mercari.mercaritest.dagger.NetModule;


public class MercariApp extends Application {

    private AppComponent appComponent;
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppHelper.setApp(this);
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(this))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}