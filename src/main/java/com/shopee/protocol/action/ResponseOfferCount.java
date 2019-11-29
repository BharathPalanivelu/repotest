package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseOfferCount extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<OfferCount> DEFAULT_OFFER_COUNT = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = OfferCount.class, tag = 3)
    public final List<OfferCount> offer_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseOfferCount(String str, Integer num, List<OfferCount> list) {
        this.requestid = str;
        this.errcode = num;
        this.offer_count = immutableCopyOf(list);
    }

    private ResponseOfferCount(Builder builder) {
        this(builder.requestid, builder.errcode, builder.offer_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseOfferCount)) {
            return false;
        }
        ResponseOfferCount responseOfferCount = (ResponseOfferCount) obj;
        if (!equals((Object) this.requestid, (Object) responseOfferCount.requestid) || !equals((Object) this.errcode, (Object) responseOfferCount.errcode) || !equals((List<?>) this.offer_count, (List<?>) responseOfferCount.offer_count)) {
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
        List<OfferCount> list = this.offer_count;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseOfferCount> {
        public Integer errcode;
        public List<OfferCount> offer_count;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseOfferCount responseOfferCount) {
            super(responseOfferCount);
            if (responseOfferCount != null) {
                this.requestid = responseOfferCount.requestid;
                this.errcode = responseOfferCount.errcode;
                this.offer_count = ResponseOfferCount.copyOf(responseOfferCount.offer_count);
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

        public Builder offer_count(List<OfferCount> list) {
            this.offer_count = checkForNulls(list);
            return this;
        }

        public ResponseOfferCount build() {
            checkRequiredFields();
            return new ResponseOfferCount(this);
        }
    }
}
