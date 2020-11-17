package com.koscomapp.trada.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultMarketIndex{
    @SerializedName("jsonrpc")
    @Expose
    public String jsonrpc;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public MarketDetail getMarketDetail() {
        return marketDetail;
    }

    public void setMarketDetail(MarketDetail marketDetail) {
        this.marketDetail = marketDetail;
    }
    @SerializedName("result")
    @Expose
    public MarketDetail marketDetail;
}