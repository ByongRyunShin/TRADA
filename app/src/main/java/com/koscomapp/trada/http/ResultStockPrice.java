package com.koscomapp.trada.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultStockPrice{
    @SerializedName("jsonrpc")
    @Expose
    public String jsonrpc;

    @SerializedName("result")
    @Expose
    public StockDetail stockDetail;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public StockDetail getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail result) {
        this.stockDetail = result;
    }
}