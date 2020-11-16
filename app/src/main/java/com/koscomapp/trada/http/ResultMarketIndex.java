package com.koscomapp.trada.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class MarketDetail{
    public String getIsuSrtCd() {
        return isuSrtCd;
    }

    public void setIsuSrtCd(String isuSrtCd) {
        this.isuSrtCd = isuSrtCd;
    }

    public int getIsuCnt() {
        return isuCnt;
    }

    public void setIsuCnt(int isuCnt) {
        this.isuCnt = isuCnt;
    }

    public String getTrdPrc() {
        return trdPrc;
    }

    public void setTrdPrc(String trdPrc) {
        this.trdPrc = trdPrc;
    }

    public String getCmpprevddTpCd() {
        return cmpprevddTpCd;
    }

    public void setCmpprevddTpCd(String cmpprevddTpCd) {
        this.cmpprevddTpCd = cmpprevddTpCd;
    }

    public double getOpnprc() {
        return opnprc;
    }

    public void setOpnprc(double opnprc) {
        this.opnprc = opnprc;
    }

    public double getHgprc() {
        return hgprc;
    }

    public void setHgprc(double hgprc) {
        this.hgprc = hgprc;
    }

    public double getLwprc() {
        return lwprc;
    }

    public void setLwprc(double lwprc) {
        this.lwprc = lwprc;
    }

    public int getAccTrdvol() {
        return accTrdvol;
    }

    public void setAccTrdvol(int accTrdvol) {
        this.accTrdvol = accTrdvol;
    }

    public int getAccTrdval() {
        return accTrdval;
    }

    public void setAccTrdval(int accTrdval) {
        this.accTrdval = accTrdval;
    }

    public int getMktcap() {
        return mktcap;
    }

    public void setMktcap(int mktcap) {
        this.mktcap = mktcap;
    }

    public double getCmpprevddPrc() {
        return cmpprevddPrc;
    }

    public void setCmpprevddPrc(double cmpprevddPrc) {
        this.cmpprevddPrc = cmpprevddPrc;
    }

    public int getListShrs() {
        return listShrs;
    }

    public void setListShrs(int listShrs) {
        this.listShrs = listShrs;
    }

    @SerializedName("isuSrtCd")
    @Expose
    public String isuSrtCd;
    @SerializedName("isuCnt")
    @Expose
    public int isuCnt;
    @SerializedName("trdPrc")
    @Expose
    public String trdPrc;
    @SerializedName("cmpprevddTpCd")
    @Expose
    public String cmpprevddTpCd;
    @SerializedName("opnprc")
    @Expose
    public double opnprc;
    @SerializedName("hgprc")
    @Expose
    public double hgprc;
    @SerializedName("lwprc")
    @Expose
    public double lwprc;
    @SerializedName("accTrdvol")
    @Expose
    public int accTrdvol;
    @SerializedName("accTrdval")
    @Expose
    public int accTrdval;
    @SerializedName("mktcap")
    @Expose
    public int mktcap;
    @SerializedName("cmpprevddPrc")
    @Expose
    public double cmpprevddPrc;
    @SerializedName("listShrs")
    @Expose
    public int listShrs;
}

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