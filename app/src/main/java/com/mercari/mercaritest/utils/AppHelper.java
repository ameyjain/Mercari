package com.mercari.mercaritest.utils;

import com.mercari.mercaritest.dagger.MercariApp;

/**
 * Created by AmeyJain on 7/11/17.
 */

public class AppHelper {

    private static MercariApp app;

    public static MercariApp getApp() {
        return app;
    }

    public static void setApp(MercariApp app) {
        AppHelper.app = app;
    }
}
