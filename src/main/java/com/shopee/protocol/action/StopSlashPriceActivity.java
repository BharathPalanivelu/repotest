package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StopSlashPriceActivity extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public StopSlashPriceActivity(String str, String str2, Long l) {
        this.requestid = str;
        this.token = str2;
        this.activity_id = l;
    }

    private StopSlashPriceActivity(Builder builder) {
        this(builder.requestid, builder.token, builder.activity_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StopSlashPriceActivity)) {
            return false;
        }
        StopSlashPriceActivity stopSlashPriceActivity = (StopSlashPriceActivity) obj;
        if (!equals((Object) this.requestid, (Object) stopSlashPriceActivity.requestid) || !equals((Object) this.token, (Object) stopSlashPriceActivity.token) || !equals((Object) this.activity_id, (Object) stopSlashPriceActivity.activity_id)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.activity_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StopSlashPriceActivity> {
        public Long activity_id;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(StopSlashPriceActivity stopSlashPriceActivity) {
            super(stopSlashPriceActivity);
            if (stopSlashPriceActivity != null) {
                this.requestid = stopSlashPriceActivity.requestid;
                this.token = stopSlashPriceActivity.token;
                this.activity_id = stopSlashPriceActivity.activity_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public StopSlashPriceActivity build() {
            return new StopSlashPriceActivity(this);
        }
    }
}
