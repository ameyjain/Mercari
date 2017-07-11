package com.mercari.mercaritest.net;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AmeyJain on 7/11/17.
 */

public class MercariServices {

    private static volatile MercariApi instance;

    public static MercariApi getInstance(Context context)
    {
        if (instance == null)
        {
            instance = createRetrofitApi(context);
        }

        return instance;
    }

    public static MercariApi createRetrofitApi(final Context applicationContext) {


        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LocalDataInterceptor(applicationContext))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(MercariApi.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy
                        (FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
                .build()
                .create(MercariApi.class);

    }
}
