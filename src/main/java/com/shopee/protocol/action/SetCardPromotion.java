package com.shopee.protocol.action;

import com.shopee.protocol.shop.CardPromotion;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetCardPromotion extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3)
    public final CardPromotion card_promotion;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetCardPromotion(String str, BackendParam backendParam, CardPromotion cardPromotion) {
        this.requestid = str;
        this.bparam = backendParam;
        this.card_promotion = cardPromotion;
    }

    private SetCardPromotion(Builder builder) {
        this(builder.requestid, builder.bparam, builder.card_promotion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCardPromotion)) {
            return false;
        }
        SetCardPromotion setCardPromotion = (SetCardPromotion) obj;
        if (!equals((Object) this.requestid, (Object) setCardPromotion.requestid) || !equals((Object) this.bparam, (Object) setCardPromotion.bparam) || !equals((Object) this.card_promotion, (Object) setCardPromotion.card_promotion)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        CardPromotion cardPromotion = this.card_promotion;
        if (cardPromotion != null) {
            i2 = cardPromotion.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCardPromotion> {
        public BackendParam bparam;
        public CardPromotion card_promotion;
        public String requestid;

        public Builder() {
        }

        public Builder(SetCardPromotion setCardPromotion) {
            super(setCardPromotion);
            if (setCardPromotion != null) {
                this.requestid = setCardPromotion.requestid;
                this.bparam = setCardPromotion.bparam;
                this.card_promotion = setCardPromotion.card_promotion;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder card_promotion(CardPromotion cardPromotion) {
            this.card_promotion = cardPromotion;
            return this;
        }

        public SetCardPromotion build() {
            return new SetCardPromotion(this);
        }
    }
}
