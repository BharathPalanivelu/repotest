package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsManualTopupDBModel extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REASON = "";
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Integer DEFAULT_STATUS = 1;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public AdsManualTopupDBModel(Long l, Long l2, Long l3, String str, String str2, Integer num, Long l4, Long l5) {
        this.id = l;
        this.shopid = l2;
        this.amount = l3;
        this.reason = str;
        this.operator = str2;
        this.status = num;
        this.ctime = l4;
        this.mtime = l5;
    }

    private AdsManualTopupDBModel(Builder builder) {
        this(builder.id, builder.shopid, builder.amount, builder.reason, builder.operator, builder.status, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsManualTopupDBModel)) {
            return false;
        }
        AdsManualTopupDBModel adsManualTopupDBModel = (AdsManualTopupDBModel) obj;
        if (!equals((Object) this.id, (Object) adsManualTopupDBModel.id) || !equals((Object) this.shopid, (Object) adsManualTopupDBModel.shopid) || !equals((Object) this.amount, (Object) adsManualTopupDBModel.amount) || !equals((Object) this.reason, (Object) adsManualTopupDBModel.reason) || !equals((Object) this.operator, (Object) adsManualTopupDBModel.operator) || !equals((Object) this.status, (Object) adsManualTopupDBModel.status) || !equals((Object) this.ctime, (Object) adsManualTopupDBModel.ctime) || !equals((Object) this.mtime, (Object) adsManualTopupDBModel.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.shopid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.amount;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.reason;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.ctime;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.mtime;
        if (l5 != null) {
            i2 = l5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsManualTopupDBModel> {
        public Long amount;
        public Long ctime;
        public Long id;
        public Long mtime;
        public String operator;
        public String reason;
        public Long shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(AdsManualTopupDBModel adsManualTopupDBModel) {
            super(adsManualTopupDBModel);
            if (adsManualTopupDBModel != null) {
                this.id = adsManualTopupDBModel.id;
                this.shopid = adsManualTopupDBModel.shopid;
                this.amount = adsManualTopupDBModel.amount;
                this.reason = adsManualTopupDBModel.reason;
                this.operator = adsManualTopupDBModel.operator;
                this.status = adsManualTopupDBModel.status;
                this.ctime = adsManualTopupDBModel.ctime;
                this.mtime = adsManualTopupDBModel.mtime;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public AdsManualTopupDBModel build() {
            return new AdsManualTopupDBModel(this);
        }
    }
}
