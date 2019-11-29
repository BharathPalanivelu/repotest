package com.shopee.protocol.action;

import com.shopee.protocol.shop.Promotion;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePromotion extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Promotion> DEFAULT_PROMOTIONS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 2)
    public final Promotion promotion;
    @ProtoField(label = Message.Label.REPEATED, messageType = Promotion.class, tag = 4)
    public final List<Promotion> promotions;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponsePromotion(String str, Promotion promotion2, Integer num, List<Promotion> list, String str2) {
        this.requestid = str;
        this.promotion = promotion2;
        this.errcode = num;
        this.promotions = immutableCopyOf(list);
        this.debug_msg = str2;
    }

    private ResponsePromotion(Builder builder) {
        this(builder.requestid, builder.promotion, builder.errcode, builder.promotions, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePromotion)) {
            return false;
        }
        ResponsePromotion responsePromotion = (ResponsePromotion) obj;
        if (!equals((Object) this.requestid, (Object) responsePromotion.requestid) || !equals((Object) this.promotion, (Object) responsePromotion.promotion) || !equals((Object) this.errcode, (Object) responsePromotion.errcode) || !equals((List<?>) this.promotions, (List<?>) responsePromotion.promotions) || !equals((Object) this.debug_msg, (Object) responsePromotion.debug_msg)) {
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
        Integer num = this.errcode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        List<Promotion> list = this.promotions;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponsePromotion> {
        public String debug_msg;
        public Integer errcode;
        public Promotion promotion;
        public List<Promotion> promotions;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponsePromotion responsePromotion) {
            super(responsePromotion);
            if (responsePromotion != null) {
                this.requestid = responsePromotion.requestid;
                this.promotion = responsePromotion.promotion;
                this.errcode = responsePromotion.errcode;
                this.promotions = ResponsePromotion.copyOf(responsePromotion.promotions);
                this.debug_msg = responsePromotion.debug_msg;
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

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder promotions(List<Promotion> list) {
            this.promotions = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponsePromotion build() {
            return new ResponsePromotion(this);
        }
    }
}
