package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AutoTopupExtInfo extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Integer DEFAULT_ERR_CODE = 0;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_THRESHOLD = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer err_code;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long threshold;

    public AutoTopupExtInfo(Long l, Long l2, Long l3, Integer num, Integer num2) {
        this.ctime = l;
        this.mtime = l2;
        this.threshold = l3;
        this.count = num;
        this.err_code = num2;
    }

    private AutoTopupExtInfo(Builder builder) {
        this(builder.ctime, builder.mtime, builder.threshold, builder.count, builder.err_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoTopupExtInfo)) {
            return false;
        }
        AutoTopupExtInfo autoTopupExtInfo = (AutoTopupExtInfo) obj;
        if (!equals((Object) this.ctime, (Object) autoTopupExtInfo.ctime) || !equals((Object) this.mtime, (Object) autoTopupExtInfo.mtime) || !equals((Object) this.threshold, (Object) autoTopupExtInfo.threshold) || !equals((Object) this.count, (Object) autoTopupExtInfo.count) || !equals((Object) this.err_code, (Object) autoTopupExtInfo.err_code)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.ctime;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.mtime;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.threshold;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.count;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.err_code;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AutoTopupExtInfo> {
        public Integer count;
        public Long ctime;
        public Integer err_code;
        public Long mtime;
        public Long threshold;

        public Builder() {
        }

        public Builder(AutoTopupExtInfo autoTopupExtInfo) {
            super(autoTopupExtInfo);
            if (autoTopupExtInfo != null) {
                this.ctime = autoTopupExtInfo.ctime;
                this.mtime = autoTopupExtInfo.mtime;
                this.threshold = autoTopupExtInfo.threshold;
                this.count = autoTopupExtInfo.count;
                this.err_code = autoTopupExtInfo.err_code;
            }
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder threshold(Long l) {
            this.threshold = l;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder err_code(Integer num) {
            this.err_code = num;
            return this;
        }

        public AutoTopupExtInfo build() {
            return new AutoTopupExtInfo(this);
        }
    }
}
