package com.shopee.protocol.action;

import com.shopee.protocol.shop.CardPromotion;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCardPromotion extends Message {
    public static final List<CardPromotion> DEFAULT_CARD_PROMOTION_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CardPromotion.class, tag = 3)
    public final List<CardPromotion> card_promotion_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCardPromotion(String str, Integer num, List<CardPromotion> list) {
        this.requestid = str;
        this.errcode = num;
        this.card_promotion_list = immutableCopyOf(list);
    }

    private ResponseCardPromotion(Builder builder) {
        this(builder.requestid, builder.errcode, builder.card_promotion_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCardPromotion)) {
            return false;
        }
        ResponseCardPromotion responseCardPromotion = (ResponseCardPromotion) obj;
        if (!equals((Object) this.requestid, (Object) responseCardPromotion.requestid) || !equals((Object) this.errcode, (Object) responseCardPromotion.errcode) || !equals((List<?>) this.card_promotion_list, (List<?>) responseCardPromotion.card_promotion_list)) {
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
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<CardPromotion> list = this.card_promotion_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCardPromotion> {
        public List<CardPromotion> card_promotion_list;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCardPromotion responseCardPromotion) {
            super(responseCardPromotion);
            if (responseCardPromotion != null) {
                this.requestid = responseCardPromotion.requestid;
                this.errcode = responseCardPromotion.errcode;
                this.card_promotion_list = ResponseCardPromotion.copyOf(responseCardPromotion.card_promotion_list);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder card_promotion_list(List<CardPromotion> list) {
            this.card_promotion_list = checkForNulls(list);
            return this;
        }

        public ResponseCardPromotion build() {
            return new ResponseCardPromotion(this);
        }
    }
}
