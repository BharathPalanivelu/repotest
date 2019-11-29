package com.airpay.paysdk.base.bean;

public class BPThirdPartyStoreInfo {
    public final String chainStoreId;
    public final String storeAddress;
    public final String storeId;
    public final String storeMemo;
    public final String storeName;
    public final String storeType;

    public BPThirdPartyStoreInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.storeId = str;
        this.storeType = str2;
        this.storeName = str3;
        this.storeMemo = str4;
        this.storeAddress = str5;
        this.chainStoreId = str6;
    }
}
