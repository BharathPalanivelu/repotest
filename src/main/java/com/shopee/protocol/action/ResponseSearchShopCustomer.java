package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchShopCustomer extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ShopCustomerGroup> DEFAULT_GROUPS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopCustomerGroup.class, tag = 3)
    public final List<ShopCustomerGroup> groups;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSearchShopCustomer(String str, Integer num, List<ShopCustomerGroup> list) {
        this.requestid = str;
        this.errcode = num;
        this.groups = immutableCopyOf(list);
    }

    private ResponseSearchShopCustomer(Builder builder) {
        this(builder.requestid, builder.errcode, builder.groups);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchShopCustomer)) {
            return false;
        }
        ResponseSearchShopCustomer responseSearchShopCustomer = (ResponseSearchShopCustomer) obj;
        if (!equals((Object) this.requestid, (Object) responseSearchShopCustomer.requestid) || !equals((Object) this.errcode, (Object) responseSearchShopCustomer.errcode) || !equals((List<?>) this.groups, (List<?>) responseSearchShopCustomer.groups)) {
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
        List<ShopCustomerGroup> list = this.groups;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchShopCustomer> {
        public Integer errcode;
        public List<ShopCustomerGroup> groups;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSearchShopCustomer responseSearchShopCustomer) {
            super(responseSearchShopCustomer);
            if (responseSearchShopCustomer != null) {
                this.requestid = responseSearchShopCustomer.requestid;
                this.errcode = responseSearchShopCustomer.errcode;
                this.groups = ResponseSearchShopCustomer.copyOf(responseSearchShopCustomer.groups);
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

        public Builder groups(List<ShopCustomerGroup> list) {
            this.groups = checkForNulls(list);
            return this;
        }

        public ResponseSearchShopCustomer build() {
            return new ResponseSearchShopCustomer(this);
        }
    }
}
