package com.koscomapp.trada.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String SW_API_ROOT_URL = "https://sandbox-apigw.koscom.co.kr/v2/";

    private static Retrofit getStockInstance() {
        return new Retrofit.Builder()
                .baseUrl(SW_API_ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIInterface getListApiService() {
        return getStockInstance().create(APIInterface.class);
    }
}
