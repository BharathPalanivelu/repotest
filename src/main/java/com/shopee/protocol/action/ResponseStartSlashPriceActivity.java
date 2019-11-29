package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseStartSlashPriceActivity extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseStartSlashPriceActivity(String str, Integer num, Long l) {
        this.requestid = str;
        this.errcode = num;
        this.activity_id = l;
    }

    private ResponseStartSlashPriceActivity(Builder builder) {
        this(builder.requestid, builder.errcode, builder.activity_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseStartSlashPriceActivity)) {
            return false;
        }
        ResponseStartSlashPriceActivity responseStartSlashPriceActivity = (ResponseStartSlashPriceActivity) obj;
        if (!equals((Object) this.requestid, (Object) responseStartSlashPriceActivity.requestid) || !equals((Object) this.errcode, (Object) responseStartSlashPriceActivity.errcode) || !equals((Object) this.activity_id, (Object) responseStartSlashPriceActivity.activity_id)) {
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
        Long l = this.activity_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseStartSlashPriceActivity> {
        public Long activity_id;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseStartSlashPriceActivity responseStartSlashPriceActivity) {
            super(responseStartSlashPriceActivity);
            if (responseStartSlashPriceActivity != null) {
                this.requestid = responseStartSlashPriceActivity.requestid;
                this.errcode = responseStartSlashPriceActivity.errcode;
                this.activity_id = responseStartSlashPriceActivity.activity_id;
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

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public ResponseStartSlashPriceActivity build() {
            return new ResponseStartSlashPriceActivity(this);
        }
    }
}
