package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PenaltyReason extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_METRIC = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_REASON_ID = 0;
    public static final String DEFAULT_REASON_TYPE = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String metric;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer reason_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String reason_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public PenaltyReason(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4) {
        this.reason_id = num;
        this.reason_type = str;
        this.metric = str2;
        this.status = num2;
        this.ctime = num3;
        this.mtime = num4;
    }

    private PenaltyReason(Builder builder) {
        this(builder.reason_id, builder.reason_type, builder.metric, builder.status, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PenaltyReason)) {
            return false;
        }
        PenaltyReason penaltyReason = (PenaltyReason) obj;
        if (!equals((Object) this.reason_id, (Object) penaltyReason.reason_id) || !equals((Object) this.reason_type, (Object) penaltyReason.reason_type) || !equals((Object) this.metric, (Object) penaltyReason.metric) || !equals((Object) this.status, (Object) penaltyReason.status) || !equals((Object) this.ctime, (Object) penaltyReason.ctime) || !equals((Object) this.mtime, (Object) penaltyReason.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.reason_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.reason_type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.metric;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PenaltyReason> {
        public Integer ctime;
        public String metric;
        public Integer mtime;
        public Integer reason_id;
        public String reason_type;
        public Integer status;

        public Builder() {
        }

        public Builder(PenaltyReason penaltyReason) {
            super(penaltyReason);
            if (penaltyReason != null) {
                this.reason_id = penaltyReason.reason_id;
                this.reason_type = penaltyReason.reason_type;
                this.metric = penaltyReason.metric;
                this.status = penaltyReason.status;
                this.ctime = penaltyReason.ctime;
                this.mtime = penaltyReason.mtime;
            }
        }

        public Builder reason_id(Integer num) {
            this.reason_id = num;
            return this;
        }

        public Builder reason_type(String str) {
            this.reason_type = str;
            return this;
        }

        public Builder metric(String str) {
            this.metric = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public PenaltyReason build() {
            return new PenaltyReason(this);
        }
    }
}
