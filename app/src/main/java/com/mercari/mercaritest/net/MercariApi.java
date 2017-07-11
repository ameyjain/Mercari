package com.mercari.mercaritest.net;

import com.mercari.mercaritest.data.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by AmeyJain on 7/11/17.
 */

public interface MercariApi {

    String BASE_URL = "https://PUT_YOUR_BASE_URL_HERE.com";

    @GET("{category}")
    Observable<Response> getItems(@Path("category") final String category);

}
