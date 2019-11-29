package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchItemList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemSearchInfo> DEFAULT_ITEM = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RESERVED_KEYWORD = "";
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemSearchInfo.class, tag = 3)
    public final List<ItemSearchInfo> item;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String reserved_keyword;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total_count;

    public ResponseSearchItemList(String str, Integer num, List<ItemSearchInfo> list, Integer num2, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.item = immutableCopyOf(list);
        this.total_count = num2;
        this.reserved_keyword = str2;
    }

    private ResponseSearchItemList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item, builder.total_count, builder.reserved_keyword);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchItemList)) {
            return false;
        }
        ResponseSearchItemList responseSearchItemList = (ResponseSearchItemList) obj;
        if (!equals((Object) this.requestid, (Object) responseSearchItemList.requestid) || !equals((Object) this.errcode, (Object) responseSearchItemList.errcode) || !equals((List<?>) this.item, (List<?>) responseSearchItemList.item) || !equals((Object) this.total_count, (Object) responseSearchItemList.total_count) || !equals((Object) this.reserved_keyword, (Object) responseSearchItemList.reserved_keyword)) {
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
        List<ItemSearchInfo> list = this.item;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total_count;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.reserved_keyword;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSearchItemList> {
        public Integer errcode;
        public List<ItemSearchInfo> item;
        public String requestid;
        public String reserved_keyword;
        public Integer total_count;

        public Builder() {
        }

        public Builder(ResponseSearchItemList responseSearchItemList) {
            super(responseSearchItemList);
            if (responseSearchItemList != null) {
                this.requestid = responseSearchItemList.requestid;
                this.errcode = responseSearchItemList.errcode;
                this.item = ResponseSearchItemList.copyOf(responseSearchItemList.item);
                this.total_count = responseSearchItemList.total_count;
                this.reserved_keyword = responseSearchItemList.reserved_keyword;
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

        public Builder item(List<ItemSearchInfo> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder reserved_keyword(String str) {
            this.reserved_keyword = str;
            return this;
        }

        public ResponseSearchItemList build() {
            checkRequiredFields();
            return new ResponseSearchItemList(this);
        }
    }
}
