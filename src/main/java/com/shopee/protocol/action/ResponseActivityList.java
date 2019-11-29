package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseActivityList extends Message {
    public static final List<ActivityItem> DEFAULT_ACTIVITY_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ActivityItem.class, tag = 3)
    public final List<ActivityItem> activity_items;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseActivityList(String str, Integer num, List<ActivityItem> list) {
        this.requestid = str;
        this.errcode = num;
        this.activity_items = immutableCopyOf(list);
    }

    private ResponseActivityList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.activity_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseActivityList)) {
            return false;
        }
        ResponseActivityList responseActivityList = (ResponseActivityList) obj;
        if (!equals((Object) this.requestid, (Object) responseActivityList.requestid) || !equals((Object) this.errcode, (Object) responseActivityList.errcode) || !equals((List<?>) this.activity_items, (List<?>) responseActivityList.activity_items)) {
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
        List<ActivityItem> list = this.activity_items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseActivityList> {
        public List<ActivityItem> activity_items;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseActivityList responseActivityList) {
            super(responseActivityList);
            if (responseActivityList != null) {
                this.requestid = responseActivityList.requestid;
                this.errcode = responseActivityList.errcode;
                this.activity_items = ResponseActivityList.copyOf(responseActivityList.activity_items);
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

        public Builder activity_items(List<ActivityItem> list) {
            this.activity_items = checkForNulls(list);
            return this;
        }

        public ResponseActivityList build() {
            checkRequiredFields();
            return new ResponseActivityList(this);
        }
    }
}
