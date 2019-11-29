package com.shopee.protocol.action;

import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseShopList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Shop> DEFAULT_SHOP = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Shop.class, tag = 3)
    public final List<Shop> shop;

    public ResponseShopList(String str, Integer num, List<Shop> list) {
        this.requestid = str;
        this.errcode = num;
        this.shop = immutableCopyOf(list);
    }

    private ResponseShopList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.shop);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopList)) {
            return false;
        }
        ResponseShopList responseShopList = (ResponseShopList) obj;
        if (!equals((Object) this.requestid, (Object) responseShopList.requestid) || !equals((Object) this.errcode, (Object) responseShopList.errcode) || !equals((List<?>) this.shop, (List<?>) responseShopList.shop)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Shop> list = this.shop;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseShopList> {
        public Integer errcode;
        public String requestid;
        public List<Shop> shop;

        public Builder() {
        }

        public Builder(ResponseShopList responseShopList) {
            super(responseShopList);
            if (responseShopList != null) {
                this.requestid = responseShopList.requestid;
                this.errcode = responseShopList.errcode;
                this.shop = ResponseShopList.copyOf(responseShopList.shop);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder shop(List<Shop> list) {
            this.shop = checkForNulls(list);
            return this;
        }

        public ResponseShopList build() {
            checkRequiredFields();
            return new ResponseShopList(this);
        }
    }
}
