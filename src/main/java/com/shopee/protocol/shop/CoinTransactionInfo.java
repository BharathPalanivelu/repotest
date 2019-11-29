package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinTransactionInfo extends Message {
    public static final String DEFAULT_ICON = "";
    public static final Long DEFAULT_PARCELID = 0L;
    public static final String DEFAULT_REASON = "";
    public static final Long DEFAULT_REJECTED_AMOUNT = 0L;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long parcelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long rejected_amount;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String title;

    public CoinTransactionInfo(String str, String str2, String str3, Long l, Long l2) {
        this.reason = str;
        this.title = str2;
        this.icon = str3;
        this.rejected_amount = l;
        this.parcelid = l2;
    }

    private CoinTransactionInfo(Builder builder) {
        this(builder.reason, builder.title, builder.icon, builder.rejected_amount, builder.parcelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinTransactionInfo)) {
            return false;
        }
        CoinTransactionInfo coinTransactionInfo = (CoinTransactionInfo) obj;
        if (!equals((Object) this.reason, (Object) coinTransactionInfo.reason) || !equals((Object) this.title, (Object) coinTransactionInfo.title) || !equals((Object) this.icon, (Object) coinTransactionInfo.icon) || !equals((Object) this.rejected_amount, (Object) coinTransactionInfo.rejected_amount) || !equals((Object) this.parcelid, (Object) coinTransactionInfo.parcelid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.reason;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.rejected_amount;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.parcelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinTransactionInfo> {
        public String icon;
        public Long parcelid;
        public String reason;
        public Long rejected_amount;
        public String title;

        public Builder() {
        }

        public Builder(CoinTransactionInfo coinTransactionInfo) {
            super(coinTransactionInfo);
            if (coinTransactionInfo != null) {
                this.reason = coinTransactionInfo.reason;
                this.title = coinTransactionInfo.title;
                this.icon = coinTransactionInfo.icon;
                this.rejected_amount = coinTransactionInfo.rejected_amount;
                this.parcelid = coinTransactionInfo.parcelid;
            }
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public Builder rejected_amount(Long l) {
            this.rejected_amount = l;
            return this;
        }

        public Builder parcelid(Long l) {
            this.parcelid = l;
            return this;
        }

        public CoinTransactionInfo build() {
            return new CoinTransactionInfo(this);
        }
    }
}
