package com.shopee.protocol.fraud_check.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CheckoutDevice extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_SHOPEE_DF = "";
    public static final String DEFAULT_TONGDUN_DF = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String shopee_df;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String tongdun_df;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public CheckoutDevice(Long l, String str, String str2, String str3, Integer num, Integer num2, f fVar) {
        this.checkoutid = l;
        this.tongdun_df = str;
        this.shopee_df = str2;
        this.country = str3;
        this.userid = num;
        this.ctime = num2;
        this.extinfo = fVar;
    }

    private CheckoutDevice(Builder builder) {
        this(builder.checkoutid, builder.tongdun_df, builder.shopee_df, builder.country, builder.userid, builder.ctime, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutDevice)) {
            return false;
        }
        CheckoutDevice checkoutDevice = (CheckoutDevice) obj;
        if (!equals((Object) this.checkoutid, (Object) checkoutDevice.checkoutid) || !equals((Object) this.tongdun_df, (Object) checkoutDevice.tongdun_df) || !equals((Object) this.shopee_df, (Object) checkoutDevice.shopee_df) || !equals((Object) this.country, (Object) checkoutDevice.country) || !equals((Object) this.userid, (Object) checkoutDevice.userid) || !equals((Object) this.ctime, (Object) checkoutDevice.ctime) || !equals((Object) this.extinfo, (Object) checkoutDevice.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.tongdun_df;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.shopee_df;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutDevice> {
        public Long checkoutid;
        public String country;
        public Integer ctime;
        public f extinfo;
        public String shopee_df;
        public String tongdun_df;
        public Integer userid;

        public Builder() {
        }

        public Builder(CheckoutDevice checkoutDevice) {
            super(checkoutDevice);
            if (checkoutDevice != null) {
                this.checkoutid = checkoutDevice.checkoutid;
                this.tongdun_df = checkoutDevice.tongdun_df;
                this.shopee_df = checkoutDevice.shopee_df;
                this.country = checkoutDevice.country;
                this.userid = checkoutDevice.userid;
                this.ctime = checkoutDevice.ctime;
                this.extinfo = checkoutDevice.extinfo;
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder tongdun_df(String str) {
            this.tongdun_df = str;
            return this;
        }

        public Builder shopee_df(String str) {
            this.shopee_df = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public CheckoutDevice build() {
            return new CheckoutDevice(this);
        }
    }
}
