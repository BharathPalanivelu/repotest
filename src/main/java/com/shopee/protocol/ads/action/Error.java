package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum Error implements ProtoEnum {
    OK(0),
    AccountDBFailed(1),
    AdsAdminInternal(2),
    HeaderNotExist(3),
    HeaderNoCountry(4),
    NoUserid(5),
    NoShopid(6),
    AdsAccountNil(7),
    InvalidCountry(8),
    ManualTopupDBFailed(9),
    BlacklistKeywordsDBFailed(10),
    WhitelistSellerDBFailed(11),
    ShopInfoFetchFailed(12),
    AdminTopupAPIFailed(13),
    InvalidRequest(14),
    InvalidTopupStatus(15);
    
    private final int value;

    private Error(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
