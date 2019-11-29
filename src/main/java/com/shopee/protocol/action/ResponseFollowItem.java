package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseFollowItem extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SimpleFollowItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SimpleFollowItem.class, tag = 2)
    public final List<SimpleFollowItem> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseFollowItem(String str, List<SimpleFollowItem> list, Integer num) {
        this.requestid = str;
        this.items = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseFollowItem(Builder builder) {
        this(builder.requestid, builder.items, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseFollowItem)) {
            return false;
        }
        ResponseFollowItem responseFollowItem = (ResponseFollowItem) obj;
        if (!equals((Object) this.requestid, (Object) responseFollowItem.requestid) || !equals((List<?>) this.items, (List<?>) responseFollowItem.items) || !equals((Object) this.errcode, (Object) responseFollowItem.errcode)) {
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
        List<SimpleFollowItem> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseFollowItem> {
        public Integer errcode;
        public List<SimpleFollowItem> items;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseFollowItem responseFollowItem) {
            super(responseFollowItem);
            if (responseFollowItem != null) {
                this.requestid = responseFollowItem.requestid;
                this.items = ResponseFollowItem.copyOf(responseFollowItem.items);
                this.errcode = responseFollowItem.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder items(List<SimpleFollowItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseFollowItem build() {
            return new ResponseFollowItem(this);
        }
    }
}
