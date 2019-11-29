package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetShopFlashSale extends Message {
    public static final List<FlashSaleBrief> DEFAULT_BRIEF_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleBrief.class, tag = 3)
    public final List<FlashSaleBrief> brief_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetShopFlashSale(String str, Integer num, List<FlashSaleBrief> list) {
        this.requestid = str;
        this.errcode = num;
        this.brief_list = immutableCopyOf(list);
    }

    private ResponseGetShopFlashSale(Builder builder) {
        this(builder.requestid, builder.errcode, builder.brief_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetShopFlashSale)) {
            return false;
        }
        ResponseGetShopFlashSale responseGetShopFlashSale = (ResponseGetShopFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) responseGetShopFlashSale.requestid) || !equals((Object) this.errcode, (Object) responseGetShopFlashSale.errcode) || !equals((List<?>) this.brief_list, (List<?>) responseGetShopFlashSale.brief_list)) {
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
        List<FlashSaleBrief> list = this.brief_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetShopFlashSale> {
        public List<FlashSaleBrief> brief_list;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetShopFlashSale responseGetShopFlashSale) {
            super(responseGetShopFlashSale);
            if (responseGetShopFlashSale != null) {
                this.requestid = responseGetShopFlashSale.requestid;
                this.errcode = responseGetShopFlashSale.errcode;
                this.brief_list = ResponseGetShopFlashSale.copyOf(responseGetShopFlashSale.brief_list);
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

        public Builder brief_list(List<FlashSaleBrief> list) {
            this.brief_list = checkForNulls(list);
            return this;
        }

        public ResponseGetShopFlashSale build() {
            return new ResponseGetShopFlashSale(this);
        }
    }
}
