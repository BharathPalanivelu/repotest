package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetFlashSale extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetFlashSale(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.promotionid = l;
        this.debug_msg = str2;
    }

    private ResponseSetFlashSale(Builder builder) {
        this(builder.requestid, builder.errcode, builder.promotionid, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetFlashSale)) {
            return false;
        }
        ResponseSetFlashSale responseSetFlashSale = (ResponseSetFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) responseSetFlashSale.requestid) || !equals((Object) this.errcode, (Object) responseSetFlashSale.errcode) || !equals((Object) this.promotionid, (Object) responseSetFlashSale.promotionid) || !equals((Object) this.debug_msg, (Object) responseSetFlashSale.debug_msg)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSetFlashSale> {
        public String debug_msg;
        public Integer errcode;
        public Long promotionid;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetFlashSale responseSetFlashSale) {
            super(responseSetFlashSale);
            if (responseSetFlashSale != null) {
                this.requestid = responseSetFlashSale.requestid;
                this.errcode = responseSetFlashSale.errcode;
                this.promotionid = responseSetFlashSale.promotionid;
                this.debug_msg = responseSetFlashSale.debug_msg;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseSetFlashSale build() {
            return new ResponseSetFlashSale(this);
        }
    }
}
