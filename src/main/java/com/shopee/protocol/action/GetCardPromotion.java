package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCardPromotion extends Message {
    public static final Integer DEFAULT_CARD_PROMOTION_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer card_promotion_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCardPromotion(String str, String str2, Integer num) {
        this.requestid = str;
        this.country = str2;
        this.card_promotion_id = num;
    }

    private GetCardPromotion(Builder builder) {
        this(builder.requestid, builder.country, builder.card_promotion_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCardPromotion)) {
            return false;
        }
        GetCardPromotion getCardPromotion = (GetCardPromotion) obj;
        if (!equals((Object) this.requestid, (Object) getCardPromotion.requestid) || !equals((Object) this.country, (Object) getCardPromotion.country) || !equals((Object) this.card_promotion_id, (Object) getCardPromotion.card_promotion_id)) {
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
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.card_promotion_id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCardPromotion> {
        public Integer card_promotion_id;
        public String country;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCardPromotion getCardPromotion) {
            super(getCardPromotion);
            if (getCardPromotion != null) {
                this.requestid = getCardPromotion.requestid;
                this.country = getCardPromotion.country;
                this.card_promotion_id = getCardPromotion.card_promotion_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder card_promotion_id(Integer num) {
            this.card_promotion_id = num;
            return this;
        }

        public GetCardPromotion build() {
            return new GetCardPromotion(this);
        }
    }
}
