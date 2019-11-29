package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReindexShop extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ReindexShop(String str, Integer num, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.country = str2;
    }

    private ReindexShop(Builder builder) {
        this(builder.requestid, builder.shopid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReindexShop)) {
            return false;
        }
        ReindexShop reindexShop = (ReindexShop) obj;
        if (!equals((Object) this.requestid, (Object) reindexShop.requestid) || !equals((Object) this.shopid, (Object) reindexShop.shopid) || !equals((Object) this.country, (Object) reindexShop.country)) {
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
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReindexShop> {
        public String country;
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ReindexShop reindexShop) {
            super(reindexShop);
            if (reindexShop != null) {
                this.requestid = reindexShop.requestid;
                this.shopid = reindexShop.shopid;
                this.country = reindexShop.country;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public ReindexShop build() {
            return new ReindexShop(this);
        }
    }
}
