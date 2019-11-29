package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShop extends Message {
    public static final Boolean DEFAULT_NEED_COUNT_FOR_LIMIT = false;
    public static final Boolean DEFAULT_NEED_DELETED = false;
    public static final Boolean DEFAULT_NEED_PICKUP_ADDRESS = false;
    public static final Boolean DEFAULT_NEED_TOTAL = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean need_count_for_limit;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_deleted;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean need_pickup_address;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean need_total;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetShop(String str, Integer num, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.requestid = str;
        this.shopid = num;
        this.token = str2;
        this.need_total = bool;
        this.need_pickup_address = bool2;
        this.need_deleted = bool3;
        this.need_count_for_limit = bool4;
    }

    private GetShop(Builder builder) {
        this(builder.requestid, builder.shopid, builder.token, builder.need_total, builder.need_pickup_address, builder.need_deleted, builder.need_count_for_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShop)) {
            return false;
        }
        GetShop getShop = (GetShop) obj;
        if (!equals((Object) this.requestid, (Object) getShop.requestid) || !equals((Object) this.shopid, (Object) getShop.shopid) || !equals((Object) this.token, (Object) getShop.token) || !equals((Object) this.need_total, (Object) getShop.need_total) || !equals((Object) this.need_pickup_address, (Object) getShop.need_pickup_address) || !equals((Object) this.need_deleted, (Object) getShop.need_deleted) || !equals((Object) this.need_count_for_limit, (Object) getShop.need_count_for_limit)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_total;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_pickup_address;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.need_deleted;
        int hashCode6 = (hashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.need_count_for_limit;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShop> {
        public Boolean need_count_for_limit;
        public Boolean need_deleted;
        public Boolean need_pickup_address;
        public Boolean need_total;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetShop getShop) {
            super(getShop);
            if (getShop != null) {
                this.requestid = getShop.requestid;
                this.shopid = getShop.shopid;
                this.token = getShop.token;
                this.need_total = getShop.need_total;
                this.need_pickup_address = getShop.need_pickup_address;
                this.need_deleted = getShop.need_deleted;
                this.need_count_for_limit = getShop.need_count_for_limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder need_total(Boolean bool) {
            this.need_total = bool;
            return this;
        }

        public Builder need_pickup_address(Boolean bool) {
            this.need_pickup_address = bool;
            return this;
        }

        public Builder need_deleted(Boolean bool) {
            this.need_deleted = bool;
            return this;
        }

        public Builder need_count_for_limit(Boolean bool) {
            this.need_count_for_limit = bool;
            return this;
        }

        public GetShop build() {
            checkRequiredFields();
            return new GetShop(this);
        }
    }
}
