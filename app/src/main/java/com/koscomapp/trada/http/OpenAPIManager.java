package com.koscomapp.trada.http;

import android.content.Context;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenAPIManager {
    private String rStockPrice;
    private String rMarketIndex;
    final String apikey="l7xxf5913ee4b7714c5eb5b18224a2e5e23e";

    public String getStockPrice(Context appCxt, String marketCode, String isuCode){
        rStockPrice="";
        APIInterface api = APIClient.getListApiService();

        Call<ResultStockPrice> call = api.getStockConclusionPrice(marketCode, isuCode, apikey);

        call.enqueue(new Callback<ResultStockPrice>() {
            @Override
            public void onResponse(Call<ResultStockPrice> call, Response<ResultStockPrice> response) {

                if(response.isSuccessful()) {
                    ResultStockPrice result = response.body();
                    rStockPrice=result.getStockDetail().getTrdPrc();
                    Toast.makeText(appCxt, result.getStockDetail().getTrdPrc(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(appCxt, response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResultStockPrice> call, Throwable t) {
                Toast.makeText(appCxt,"onFailure",Toast.LENGTH_SHORT).show();
            }
        });
        return rStockPrice;
    }

    public String getMarketIndex(Context appCxt, String marketCode){
        rMarketIndex="";
        APIInterface api = APIClient.getListApiService();

        Call<ResultMarketIndex> call = api.getMarketIndex(marketCode, apikey);

        call.enqueue(new Callback<ResultMarketIndex>() {
            @Override
            public void onResponse(Call<ResultMarketIndex> call, Response<ResultMarketIndex> response) {

                if(response.isSuccessful()) {
                    ResultMarketIndex result = response.body();
                    rMarketIndex=result.getMarketDetail().getTrdPrc();
                } else {
                    Toast.makeText(appCxt, response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResultMarketIndex> call, Throwable t) {
                Toast.makeText(appCxt,"onFailure",Toast.LENGTH_SHORT).show();
            }
        });
        return rMarketIndex;
    }
}
