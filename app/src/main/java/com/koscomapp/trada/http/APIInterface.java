package com.koscomapp.trada.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @Headers({"Accept: application/json"})
    @GET("market/stocks/{marketCode}/{isuCode}/price")
    Call<ResultStockPrice> getStockConclusionPrice(
            @Path("marketCode") String marketCode,
            @Path("isuCode") String isuCode,
            @Query("apikey") String apikey);

    @Headers({"Accept: application/json"})
    @GET("market/stocks/{marketCode}/index")
    Call<ResultMarketIndex> getMarketIndex(
            @Path("marketCode") String marketCode,
            @Query("apikey") String apikey);
}