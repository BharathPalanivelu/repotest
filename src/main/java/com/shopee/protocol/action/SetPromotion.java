package com.shopee.protocol.action;

import com.shopee.protocol.shop.Promotion;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetPromotion extends Message {
    public static final Boolean DEFAULT_CREATE_PUBLIC_VOUCHER = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean create_public_voucher;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Promotion promotion;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public SetPromotion(String str, Promotion promotion2, String str2, Boolean bool) {
        this.requestid = str;
        this.promotion = promotion2;
        this.token = str2;
        this.create_public_voucher = bool;
    }

    private SetPromotion(Builder builder) {
        this(builder.requestid, builder.promotion, builder.token, builder.create_public_voucher);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetPromotion)) {
            return false;
        }
        SetPromotion setPromotion = (SetPromotion) obj;
        if (!equals((Object) this.requestid, (Object) setPromotion.requestid) || !equals((Object) this.promotion, (Object) setPromotion.promotion) || !equals((Object) this.token, (Object) setPromotion.token) || !equals((Object) this.create_public_voucher, (Object) setPromotion.create_public_voucher)) {
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
        Promotion promotion2 = this.promotion;
        int hashCode2 = (hashCode + (promotion2 != null ? promotion2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.create_public_voucher;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetPromotion> {
        public Boolean create_public_voucher;
        public Promotion promotion;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetPromotion setPromotion) {
            super(setPromotion);
            if (setPromotion != null) {
                this.requestid = setPromotion.requestid;
                this.promotion = setPromotion.promotion;
                this.token = setPromotion.token;
                this.create_public_voucher = setPromotion.create_public_voucher;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotion(Promotion promotion2) {
            this.promotion = promotion2;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder create_public_voucher(Boolean bool) {
            this.create_public_voucher = bool;
            return this;
        }

        public SetPromotion build() {
            checkRequiredFields();
            return new SetPromotion(this);
        }
    }
}
