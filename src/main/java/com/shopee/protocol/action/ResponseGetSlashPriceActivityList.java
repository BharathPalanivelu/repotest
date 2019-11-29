package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetSlashPriceActivityList extends Message {
    public static final List<SlashPriceActivityResponse> DEFAULT_ACTIVITIES = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = SlashPriceActivityResponse.class, tag = 3)
    public final List<SlashPriceActivityResponse> activities;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetSlashPriceActivityList(String str, Integer num, List<SlashPriceActivityResponse> list) {
        this.requestid = str;
        this.errcode = num;
        this.activities = immutableCopyOf(list);
    }

    private ResponseGetSlashPriceActivityList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.activities);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetSlashPriceActivityList)) {
            return false;
        }
        ResponseGetSlashPriceActivityList responseGetSlashPriceActivityList = (ResponseGetSlashPriceActivityList) obj;
        if (!equals((Object) this.requestid, (Object) responseGetSlashPriceActivityList.requestid) || !equals((Object) this.errcode, (Object) responseGetSlashPriceActivityList.errcode) || !equals((List<?>) this.activities, (List<?>) responseGetSlashPriceActivityList.activities)) {
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
        List<SlashPriceActivityResponse> list = this.activities;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetSlashPriceActivityList> {
        public List<SlashPriceActivityResponse> activities;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetSlashPriceActivityList responseGetSlashPriceActivityList) {
            super(responseGetSlashPriceActivityList);
            if (responseGetSlashPriceActivityList != null) {
                this.requestid = responseGetSlashPriceActivityList.requestid;
                this.errcode = responseGetSlashPriceActivityList.errcode;
                this.activities = ResponseGetSlashPriceActivityList.copyOf(responseGetSlashPriceActivityList.activities);
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

        public Builder activities(List<SlashPriceActivityResponse> list) {
            this.activities = checkForNulls(list);
            return this;
        }

        public ResponseGetSlashPriceActivityList build() {
            return new ResponseGetSlashPriceActivityList(this);
        }
    }
}
