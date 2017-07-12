package com.mercari.mercaritest.dagger;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mercari.mercaritest.net.LocalDataInterceptor;
import com.mercari.mercaritest.net.MercariApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AmeyJain on 7/11/17.
 */

@Module
public class NetModule {

    private Context context;

    public NetModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    MercariApi provideMercariTestApi() {

        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LocalDataInterceptor(context))
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
