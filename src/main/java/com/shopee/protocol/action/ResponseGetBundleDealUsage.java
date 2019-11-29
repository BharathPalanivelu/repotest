package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetBundleDealUsage extends Message {
    public static final List<Integer> DEFAULT_COUNT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> count;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetBundleDealUsage(String str, Integer num, List<Integer> list) {
        this.requestid = str;
        this.errcode = num;
        this.count = immutableCopyOf(list);
    }

    private ResponseGetBundleDealUsage(Builder builder) {
        this(builder.requestid, builder.errcode, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetBundleDealUsage)) {
            return false;
        }
        ResponseGetBundleDealUsage responseGetBundleDealUsage = (ResponseGetBundleDealUsage) obj;
        if (!equals((Object) this.requestid, (Object) responseGetBundleDealUsage.requestid) || !equals((Object) this.errcode, (Object) responseGetBundleDealUsage.errcode) || !equals((List<?>) this.count, (List<?>) responseGetBundleDealUsage.count)) {
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
        List<Integer> list = this.count;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetBundleDealUsage> {
        public List<Integer> count;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetBundleDealUsage responseGetBundleDealUsage) {
            super(responseGetBundleDealUsage);
            if (responseGetBundleDealUsage != null) {
                this.requestid = responseGetBundleDealUsage.requestid;
                this.errcode = responseGetBundleDealUsage.errcode;
                this.count = ResponseGetBundleDealUsage.copyOf(responseGetBundleDealUsage.count);
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

        public Builder count(List<Integer> list) {
            this.count = checkForNulls(list);
            return this;
        }

        public ResponseGetBundleDealUsage build() {
            return new ResponseGetBundleDealUsage(this);
        }
    }
}
