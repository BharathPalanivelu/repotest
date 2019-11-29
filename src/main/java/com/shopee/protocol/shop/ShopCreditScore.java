package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopCreditScore extends Message {
    public static final Integer DEFAULT_BANNED = 0;
    public static final Double DEFAULT_BANNED_SCORE;
    public static final Double DEFAULT_BOOSTING;
    public static final Double DEFAULT_CANCEL_RATE;
    public static final Double DEFAULT_CHAT_RESPONSE_SCORE;
    public static final Double DEFAULT_CHAT_SCORE;
    public static final String DEFAULT_COUNTRY = "";
    public static final Double DEFAULT_CUMULATIVE_ORDER_SCORE;
    public static final Double DEFAULT_LISTING_SCORE;
    public static final Double DEFAULT_ORDER_SCORE;
    public static final Double DEFAULT_RATE_SCORE;
    public static final Double DEFAULT_REFUND_SCORE;
    public static final Double DEFAULT_SHIPPING;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Double DEFAULT_TOTAL;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer banned;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double banned_score;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double boosting;
    @ProtoField(tag = 15, type = Message.Datatype.DOUBLE)
    public final Double cancel_rate;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double chat_response_score;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double chat_score;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double cumulative_order_score;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double listing_score;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double order_score;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double rate_score;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double refund_score;
    @ProtoField(tag = 12, type = Message.Datatype.DOUBLE)
    public final Double shipping;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double total;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_RATE_SCORE = valueOf;
        DEFAULT_REFUND_SCORE = valueOf;
        DEFAULT_CHAT_SCORE = valueOf;
        DEFAULT_BANNED_SCORE = valueOf;
        DEFAULT_LISTING_SCORE = valueOf;
        DEFAULT_ORDER_SCORE = valueOf;
        DEFAULT_CUMULATIVE_ORDER_SCORE = valueOf;
        DEFAULT_BOOSTING = valueOf;
        DEFAULT_CHAT_RESPONSE_SCORE = valueOf;
        DEFAULT_TOTAL = valueOf;
        DEFAULT_SHIPPING = valueOf;
        DEFAULT_CANCEL_RATE = valueOf;
    }

    public ShopCreditScore(Integer num, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, Double d12, Integer num2, String str, Double d13) {
        this.shopid = num;
        this.rate_score = d2;
        this.refund_score = d3;
        this.chat_score = d4;
        this.banned_score = d5;
        this.listing_score = d6;
        this.order_score = d7;
        this.cumulative_order_score = d8;
        this.boosting = d9;
        this.chat_response_score = d10;
        this.total = d11;
        this.shipping = d12;
        this.banned = num2;
        this.country = str;
        this.cancel_rate = d13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ShopCreditScore(com.shopee.protocol.shop.ShopCreditScore.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.shopid
            java.lang.Double r3 = r0.rate_score
            java.lang.Double r4 = r0.refund_score
            java.lang.Double r5 = r0.chat_score
            java.lang.Double r6 = r0.banned_score
            java.lang.Double r7 = r0.listing_score
            java.lang.Double r8 = r0.order_score
            java.lang.Double r9 = r0.cumulative_order_score
            java.lang.Double r10 = r0.boosting
            java.lang.Double r11 = r0.chat_response_score
            java.lang.Double r12 = r0.total
            java.lang.Double r13 = r0.shipping
            java.lang.Integer r14 = r0.banned
            java.lang.String r15 = r0.country
            java.lang.Double r1 = r0.cancel_rate
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ShopCreditScore.<init>(com.shopee.protocol.shop.ShopCreditScore$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCreditScore)) {
            return false;
        }
        ShopCreditScore shopCreditScore = (ShopCreditScore) obj;
        if (!equals((Object) this.shopid, (Object) shopCreditScore.shopid) || !equals((Object) this.rate_score, (Object) shopCreditScore.rate_score) || !equals((Object) this.refund_score, (Object) shopCreditScore.refund_score) || !equals((Object) this.chat_score, (Object) shopCreditScore.chat_score) || !equals((Object) this.banned_score, (Object) shopCreditScore.banned_score) || !equals((Object) this.listing_score, (Object) shopCreditScore.listing_score) || !equals((Object) this.order_score, (Object) shopCreditScore.order_score) || !equals((Object) this.cumulative_order_score, (Object) shopCreditScore.cumulative_order_score) || !equals((Object) this.boosting, (Object) shopCreditScore.boosting) || !equals((Object) this.chat_response_score, (Object) shopCreditScore.chat_response_score) || !equals((Object) this.total, (Object) shopCreditScore.total) || !equals((Object) this.shipping, (Object) shopCreditScore.shipping) || !equals((Object) this.banned, (Object) shopCreditScore.banned) || !equals((Object) this.country, (Object) shopCreditScore.country) || !equals((Object) this.cancel_rate, (Object) shopCreditScore.cancel_rate)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Double d2 = this.rate_score;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.refund_score;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.chat_score;
        int hashCode4 = (hashCode3 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.banned_score;
        int hashCode5 = (hashCode4 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Double d6 = this.listing_score;
        int hashCode6 = (hashCode5 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Double d7 = this.order_score;
        int hashCode7 = (hashCode6 + (d7 != null ? d7.hashCode() : 0)) * 37;
        Double d8 = this.cumulative_order_score;
        int hashCode8 = (hashCode7 + (d8 != null ? d8.hashCode() : 0)) * 37;
        Double d9 = this.boosting;
        int hashCode9 = (hashCode8 + (d9 != null ? d9.hashCode() : 0)) * 37;
        Double d10 = this.chat_response_score;
        int hashCode10 = (hashCode9 + (d10 != null ? d10.hashCode() : 0)) * 37;
        Double d11 = this.total;
        int hashCode11 = (hashCode10 + (d11 != null ? d11.hashCode() : 0)) * 37;
        Double d12 = this.shipping;
        int hashCode12 = (hashCode11 + (d12 != null ? d12.hashCode() : 0)) * 37;
        Integer num2 = this.banned;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode14 = (hashCode13 + (str != null ? str.hashCode() : 0)) * 37;
        Double d13 = this.cancel_rate;
        if (d13 != null) {
            i2 = d13.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCreditScore> {
        public Integer banned;
        public Double banned_score;
        public Double boosting;
        public Double cancel_rate;
        public Double chat_response_score;
        public Double chat_score;
        public String country;
        public Double cumulative_order_score;
        public Double listing_score;
        public Double order_score;
        public Double rate_score;
        public Double refund_score;
        public Double shipping;
        public Integer shopid;
        public Double total;

        public Builder() {
        }

        public Builder(ShopCreditScore shopCreditScore) {
            super(shopCreditScore);
            if (shopCreditScore != null) {
                this.shopid = shopCreditScore.shopid;
                this.rate_score = shopCreditScore.rate_score;
                this.refund_score = shopCreditScore.refund_score;
                this.chat_score = shopCreditScore.chat_score;
                this.banned_score = shopCreditScore.banned_score;
                this.listing_score = shopCreditScore.listing_score;
                this.order_score = shopCreditScore.order_score;
                this.cumulative_order_score = shopCreditScore.cumulative_order_score;
                this.boosting = shopCreditScore.boosting;
                this.chat_response_score = shopCreditScore.chat_response_score;
                this.total = shopCreditScore.total;
                this.shipping = shopCreditScore.shipping;
                this.banned = shopCreditScore.banned;
                this.country = shopCreditScore.country;
                this.cancel_rate = shopCreditScore.cancel_rate;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder rate_score(Double d2) {
            this.rate_score = d2;
            return this;
        }

        public Builder refund_score(Double d2) {
            this.refund_score = d2;
            return this;
        }

        public Builder chat_score(Double d2) {
            this.chat_score = d2;
            return this;
        }

        public Builder banned_score(Double d2) {
            this.banned_score = d2;
            return this;
        }

        public Builder listing_score(Double d2) {
            this.listing_score = d2;
            return this;
        }

        public Builder order_score(Double d2) {
            this.order_score = d2;
            return this;
        }

        public Builder cumulative_order_score(Double d2) {
            this.cumulative_order_score = d2;
            return this;
        }

        public Builder boosting(Double d2) {
            this.boosting = d2;
            return this;
        }

        public Builder chat_response_score(Double d2) {
            this.chat_response_score = d2;
            return this;
        }

        public Builder total(Double d2) {
            this.total = d2;
            return this;
        }

        public Builder shipping(Double d2) {
            this.shipping = d2;
            return this;
        }

        public Builder banned(Integer num) {
            this.banned = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder cancel_rate(Double d2) {
            this.cancel_rate = d2;
            return this;
        }

        public ShopCreditScore build() {
            return new ShopCreditScore(this);
        }
    }
}
