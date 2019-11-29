package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopCollection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseShopCList extends Message {
    public static final List<ShopCollection> DEFAULT_CLIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopCollection.class, tag = 3)
    public final List<ShopCollection> clist;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseShopCList(String str, Integer num, List<ShopCollection> list) {
        this.requestid = str;
        this.errcode = num;
        this.clist = immutableCopyOf(list);
    }

    private ResponseShopCList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.clist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopCList)) {
            return false;
        }
        ResponseShopCList responseShopCList = (ResponseShopCList) obj;
        if (!equals((Object) this.requestid, (Object) responseShopCList.requestid) || !equals((Object) this.errcode, (Object) responseShopCList.errcode) || !equals((List<?>) this.clist, (List<?>) responseShopCList.clist)) {
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
        List<ShopCollection> list = this.clist;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseShopCList> {
        public List<ShopCollection> clist;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseShopCList responseShopCList) {
            super(responseShopCList);
            if (responseShopCList != null) {
                this.requestid = responseShopCList.requestid;
                this.errcode = responseShopCList.errcode;
                this.clist = ResponseShopCList.copyOf(responseShopCList.clist);
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

        public Builder clist(List<ShopCollection> list) {
            this.clist = checkForNulls(list);
            return this;
        }

        public ResponseShopCList build() {
            checkRequiredFields();
            return new ResponseShopCList(this);
        }
    }
}
