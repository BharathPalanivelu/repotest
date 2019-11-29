package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsManualTopup extends Message {
    public static final String DEFAULT_SHOPNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String shopname;
    @ProtoField(tag = 1)
    public final AdsManualTopupDBModel topup;

    public AdsManualTopup(AdsManualTopupDBModel adsManualTopupDBModel, String str) {
        this.topup = adsManualTopupDBModel;
        this.shopname = str;
    }

    private AdsManualTopup(Builder builder) {
        this(builder.topup, builder.shopname);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsManualTopup)) {
            return false;
        }
        AdsManualTopup adsManualTopup = (AdsManualTopup) obj;
        if (!equals((Object) this.topup, (Object) adsManualTopup.topup) || !equals((Object) this.shopname, (Object) adsManualTopup.shopname)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        AdsManualTopupDBModel adsManualTopupDBModel = this.topup;
        int i2 = 0;
        int hashCode = (adsManualTopupDBModel != null ? adsManualTopupDBModel.hashCode() : 0) * 37;
        String str = this.shopname;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsManualTopup> {
        public String shopname;
        public AdsManualTopupDBModel topup;

        public Builder() {
        }

        public Builder(AdsManualTopup adsManualTopup) {
            super(adsManualTopup);
            if (adsManualTopup != null) {
                this.topup = adsManualTopup.topup;
                this.shopname = adsManualTopup.shopname;
            }
        }

        public Builder topup(AdsManualTopupDBModel adsManualTopupDBModel) {
            this.topup = adsManualTopupDBModel;
            return this;
        }

        public Builder shopname(String str) {
            this.shopname = str;
            return this;
        }

        public AdsManualTopup build() {
            return new AdsManualTopup(this);
        }
    }
}
