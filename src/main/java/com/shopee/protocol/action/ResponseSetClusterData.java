package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetClusterData extends Message {
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetClusterData(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.collection_id = num;
        this.errcode = num2;
    }

    private ResponseSetClusterData(Builder builder) {
        this(builder.requestid, builder.collection_id, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetClusterData)) {
            return false;
        }
        ResponseSetClusterData responseSetClusterData = (ResponseSetClusterData) obj;
        if (!equals((Object) this.requestid, (Object) responseSetClusterData.requestid) || !equals((Object) this.collection_id, (Object) responseSetClusterData.collection_id) || !equals((Object) this.errcode, (Object) responseSetClusterData.errcode)) {
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
        Integer num = this.collection_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.errcode;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSetClusterData> {
        public Integer collection_id;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetClusterData responseSetClusterData) {
            super(responseSetClusterData);
            if (responseSetClusterData != null) {
                this.requestid = responseSetClusterData.requestid;
                this.collection_id = responseSetClusterData.collection_id;
                this.errcode = responseSetClusterData.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseSetClusterData build() {
            return new ResponseSetClusterData(this);
        }
    }
}
