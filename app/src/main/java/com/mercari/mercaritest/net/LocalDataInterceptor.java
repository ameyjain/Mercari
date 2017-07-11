package com.mercari.mercaritest.net;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by AmeyJain on 7/11/17.
 * This class treats the local json as if they were pointing to a real API service
 *
 */

public class LocalDataInterceptor implements Interceptor {

    private static final int BUFFER_SIZE = 1024 * 4;

    private Context context;

    public LocalDataInterceptor(final Context context) {
        this.context = context.getApplicationContext();
    }

    private static byte[] toByteArray(final InputStream is) throws IOException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[BUFFER_SIZE];
            int n;
            while ((n = is.read(b)) != -1) {
                output.write(b, 0, n);
            }
            return output.toByteArray();
        } finally {
            output.close();
        }
    }

    /**
     * Get input stream from the local json file.
     * Build and return mock response.
     *
     */
    @Override
    public Response intercept(final Interceptor.Chain chain) throws IOException {
        final String fileName = chain.request().url().uri().getPath().replace("/", "");

        final InputStream inputStream = context.getAssets().open(fileName);
        return new Response.Builder()
                .addHeader("content-type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), toByteArray(inputStream)))
                .code(200)
                .message("Mock response from assets/" + fileName)
                .protocol(Protocol.HTTP_1_0)
                .request(chain.request())
                .build();
    }
}
