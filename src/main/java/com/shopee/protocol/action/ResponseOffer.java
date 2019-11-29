package com.shopee.protocol.action;

import com.shopee.protocol.shop.Offer;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseOffer extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Offer> DEFAULT_OFFER = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = Offer.class, tag = 3)
    public final List<Offer> offer;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseOffer(String str, Integer num, List<Offer> list) {
        this.requestid = str;
        this.errcode = num;
        this.offer = immutableCopyOf(list);
    }

    private ResponseOffer(Builder builder) {
        this(builder.requestid, builder.errcode, builder.offer);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseOffer)) {
            return false;
        }
        ResponseOffer responseOffer = (ResponseOffer) obj;
        if (!equals((Object) this.requestid, (Object) responseOffer.requestid) || !equals((Object) this.errcode, (Object) responseOffer.errcode) || !equals((List<?>) this.offer, (List<?>) responseOffer.offer)) {
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
        List<Offer> list = this.offer;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseOffer> {
        public Integer errcode;
        public List<Offer> offer;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseOffer responseOffer) {
            super(responseOffer);
            if (responseOffer != null) {
                this.requestid = responseOffer.requestid;
                this.errcode = responseOffer.errcode;
                this.offer = ResponseOffer.copyOf(responseOffer.offer);
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

        public Builder offer(List<Offer> list) {
            this.offer = checkForNulls(list);
            return this;
        }

        public ResponseOffer build() {
            checkRequiredFields();
            return new ResponseOffer(this);
        }
    }
}
