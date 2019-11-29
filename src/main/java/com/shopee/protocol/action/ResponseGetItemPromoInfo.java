package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetItemPromoInfo extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemPromoInfo> DEFAULT_PROMO_INFO = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemPromoInfo.class, tag = 2)
    public final List<ItemPromoInfo> promo_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetItemPromoInfo(String str, List<ItemPromoInfo> list, Integer num) {
        this.requestid = str;
        this.promo_info = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseGetItemPromoInfo(Builder builder) {
        this(builder.requestid, builder.promo_info, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetItemPromoInfo)) {
            return false;
        }
        ResponseGetItemPromoInfo responseGetItemPromoInfo = (ResponseGetItemPromoInfo) obj;
        if (!equals((Object) this.requestid, (Object) responseGetItemPromoInfo.requestid) || !equals((List<?>) this.promo_info, (List<?>) responseGetItemPromoInfo.promo_info) || !equals((Object) this.errcode, (Object) responseGetItemPromoInfo.errcode)) {
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
        List<ItemPromoInfo> list = this.promo_info;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetItemPromoInfo> {
        public Integer errcode;
        public List<ItemPromoInfo> promo_info;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetItemPromoInfo responseGetItemPromoInfo) {
            super(responseGetItemPromoInfo);
            if (responseGetItemPromoInfo != null) {
                this.requestid = responseGetItemPromoInfo.requestid;
                this.promo_info = ResponseGetItemPromoInfo.copyOf(responseGetItemPromoInfo.promo_info);
                this.errcode = responseGetItemPromoInfo.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promo_info(List<ItemPromoInfo> list) {
            this.promo_info = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseGetItemPromoInfo build() {
            return new ResponseGetItemPromoInfo(this);
        }
    }
}
