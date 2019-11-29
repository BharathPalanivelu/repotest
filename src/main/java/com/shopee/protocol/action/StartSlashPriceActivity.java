package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StartSlashPriceActivity extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public StartSlashPriceActivity(String str, String str2, Integer num, Long l, Long l2, String str3) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
        this.country = str3;
    }

    private StartSlashPriceActivity(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid, builder.itemid, builder.modelid, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartSlashPriceActivity)) {
            return false;
        }
        StartSlashPriceActivity startSlashPriceActivity = (StartSlashPriceActivity) obj;
        if (!equals((Object) this.requestid, (Object) startSlashPriceActivity.requestid) || !equals((Object) this.token, (Object) startSlashPriceActivity.token) || !equals((Object) this.shopid, (Object) startSlashPriceActivity.shopid) || !equals((Object) this.itemid, (Object) startSlashPriceActivity.itemid) || !equals((Object) this.modelid, (Object) startSlashPriceActivity.modelid) || !equals((Object) this.country, (Object) startSlashPriceActivity.country)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StartSlashPriceActivity> {
        public String country;
        public Long itemid;
        public Long modelid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(StartSlashPriceActivity startSlashPriceActivity) {
            super(startSlashPriceActivity);
            if (startSlashPriceActivity != null) {
                this.requestid = startSlashPriceActivity.requestid;
                this.token = startSlashPriceActivity.token;
                this.shopid = startSlashPriceActivity.shopid;
                this.itemid = startSlashPriceActivity.itemid;
                this.modelid = startSlashPriceActivity.modelid;
                this.country = startSlashPriceActivity.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public StartSlashPriceActivity build() {
            return new StartSlashPriceActivity(this);
        }
    }
}
