package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseDiscountUsage extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemDiscountUsage> DEFAULT_ITEM_DISCOUNT_USAGE = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemDiscountUsage.class, tag = 3)
    public final List<ItemDiscountUsage> item_discount_usage;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseDiscountUsage(String str, Integer num, List<ItemDiscountUsage> list) {
        this.requestid = str;
        this.errcode = num;
        this.item_discount_usage = immutableCopyOf(list);
    }

    private ResponseDiscountUsage(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item_discount_usage);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseDiscountUsage)) {
            return false;
        }
        ResponseDiscountUsage responseDiscountUsage = (ResponseDiscountUsage) obj;
        if (!equals((Object) this.requestid, (Object) responseDiscountUsage.requestid) || !equals((Object) this.errcode, (Object) responseDiscountUsage.errcode) || !equals((List<?>) this.item_discount_usage, (List<?>) responseDiscountUsage.item_discount_usage)) {
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
        List<ItemDiscountUsage> list = this.item_discount_usage;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseDiscountUsage> {
        public Integer errcode;
        public List<ItemDiscountUsage> item_discount_usage;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseDiscountUsage responseDiscountUsage) {
            super(responseDiscountUsage);
            if (responseDiscountUsage != null) {
                this.requestid = responseDiscountUsage.requestid;
                this.errcode = responseDiscountUsage.errcode;
                this.item_discount_usage = ResponseDiscountUsage.copyOf(responseDiscountUsage.item_discount_usage);
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

        public Builder item_discount_usage(List<ItemDiscountUsage> list) {
            this.item_discount_usage = checkForNulls(list);
            return this;
        }

        public ResponseDiscountUsage build() {
            return new ResponseDiscountUsage(this);
        }
    }
}
