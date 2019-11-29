package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetSlashPriceItemList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SlashPriceItemResponse> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SlashPriceItemResponse.class, tag = 3)
    public final List<SlashPriceItemResponse> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetSlashPriceItemList(String str, Integer num, List<SlashPriceItemResponse> list) {
        this.requestid = str;
        this.errcode = num;
        this.items = immutableCopyOf(list);
    }

    private ResponseGetSlashPriceItemList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetSlashPriceItemList)) {
            return false;
        }
        ResponseGetSlashPriceItemList responseGetSlashPriceItemList = (ResponseGetSlashPriceItemList) obj;
        if (!equals((Object) this.requestid, (Object) responseGetSlashPriceItemList.requestid) || !equals((Object) this.errcode, (Object) responseGetSlashPriceItemList.errcode) || !equals((List<?>) this.items, (List<?>) responseGetSlashPriceItemList.items)) {
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
        List<SlashPriceItemResponse> list = this.items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetSlashPriceItemList> {
        public Integer errcode;
        public List<SlashPriceItemResponse> items;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetSlashPriceItemList responseGetSlashPriceItemList) {
            super(responseGetSlashPriceItemList);
            if (responseGetSlashPriceItemList != null) {
                this.requestid = responseGetSlashPriceItemList.requestid;
                this.errcode = responseGetSlashPriceItemList.errcode;
                this.items = ResponseGetSlashPriceItemList.copyOf(responseGetSlashPriceItemList.items);
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

        public Builder items(List<SlashPriceItemResponse> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public ResponseGetSlashPriceItemList build() {
            return new ResponseGetSlashPriceItemList(this);
        }
    }
}
