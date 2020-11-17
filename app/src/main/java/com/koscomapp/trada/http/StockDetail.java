package com.koscomapp.trada.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockDetail{
    public String isuSrtCd;

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

    public int getOpnprc() {
        return opnprc;
    }

    public void setOpnprc(int opnprc) {
        this.opnprc = opnprc;
    }

    public int getHgprc() {
        return hgprc;
    }

    public void setHgprc(int hgprc) {
        this.hgprc = hgprc;
    }

    public int getLwprc() {
        return lwprc;
    }

    public void setLwprc(int lwprc) {
        this.lwprc = lwprc;
    }

    public int getAccTrdvol() {
        return accTrdvol;
    }

    public void setAccTrdvol(int accTrdvol) {
        this.accTrdvol = accTrdvol;
    }

    public int getTrdTm() {
        return trdTm;
    }

    public void setTrdTm(int trdTm) {
        this.trdTm = trdTm;
    }

    public int getTrdvol() {
        return trdvol;
    }

    public void setTrdvol(int trdvol) {
        this.trdvol = trdvol;
    }

    public long getAccTrdval() {
        return accTrdval;
    }

    public void setAccTrdval(long accTrdval) {
        this.accTrdval = accTrdval;
    }

    public int getCmpprevddPrc() {
        return cmpprevddPrc;
    }

    public void setCmpprevddPrc(int cmpprevddPrc) {
        this.cmpprevddPrc = cmpprevddPrc;
    }

    public int getBidordPrc_1() {
        return bidordPrc_1;
    }

    public void setBidordPrc_1(int bidordPrc_1) {
        this.bidordPrc_1 = bidordPrc_1;
    }

    public int getAskordPrc_1() {
        return askordPrc_1;
    }

    public void setAskordPrc_1(int askordPrc_1) {
        this.askordPrc_1 = askordPrc_1;
    }

    public int getLstAskbidTpCd() {
        return lstAskbidTpCd;
    }

    public void setLstAskbidTpCd(int lstAskbidTpCd) {
        this.lstAskbidTpCd = lstAskbidTpCd;
    }

    @SerializedName("trdPrc")
    @Expose
    public String trdPrc;

    @SerializedName("cmpprevddTpCd")
    @Expose
    public String cmpprevddTpCd;

    @SerializedName("opnprc")
    @Expose
    public int opnprc;

    @SerializedName("hgprc")
    @Expose
    public int hgprc;

    @SerializedName("lwprc")
    @Expose
    public int lwprc;

    @SerializedName("accTrdvol")
    @Expose
    public int accTrdvol;

    @SerializedName("trdTm")
    @Expose
    public int trdTm;

    @SerializedName("trdvol")
    @Expose
    public int trdvol;

    @SerializedName("accTrdval")
    @Expose
    public long accTrdval;

    @SerializedName("cmpprevddPrc")
    @Expose
    public int cmpprevddPrc;

    @SerializedName("bidordPrc_1")
    @Expose
    public int bidordPrc_1;

    @SerializedName("askordPrc_1")
    @Expose
    public int askordPrc_1;

    @SerializedName("lstAskbidTpCd")
    @Expose
    public int lstAskbidTpCd;

    public String getIsuSrtCd() {
        return isuSrtCd;
    }

    public void setIsuSrtCd(String isuSrtCd) {
        this.isuSrtCd = isuSrtCd;
    }
}