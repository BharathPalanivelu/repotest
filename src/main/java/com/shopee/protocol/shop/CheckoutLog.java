package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CheckoutLog extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_FLAG = 0;
    public static final f DEFAULT_HASHED_DEVICE = f.f32736b;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f hashed_device;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public CheckoutLog(Long l, Integer num, f fVar, Integer num2, Integer num3, Integer num4, Long l2) {
        this.checkoutid = l;
        this.userid = num;
        this.hashed_device = fVar;
        this.ctime = num2;
        this.status = num3;
        this.flag = num4;
        this.promotionid = l2;
    }

    private CheckoutLog(Builder builder) {
        this(builder.checkoutid, builder.userid, builder.hashed_device, builder.ctime, builder.status, builder.flag, builder.promotionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutLog)) {
            return false;
        }
        CheckoutLog checkoutLog = (CheckoutLog) obj;
        if (!equals((Object) this.checkoutid, (Object) checkoutLog.checkoutid) || !equals((Object) this.userid, (Object) checkoutLog.userid) || !equals((Object) this.hashed_device, (Object) checkoutLog.hashed_device) || !equals((Object) this.ctime, (Object) checkoutLog.ctime) || !equals((Object) this.status, (Object) checkoutLog.status) || !equals((Object) this.flag, (Object) checkoutLog.flag) || !equals((Object) this.promotionid, (Object) checkoutLog.promotionid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.hashed_device;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.flag;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.promotionid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutLog> {
        public Long checkoutid;
        public Integer ctime;
        public Integer flag;
        public f hashed_device;
        public Long promotionid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(CheckoutLog checkoutLog) {
            super(checkoutLog);
            if (checkoutLog != null) {
                this.checkoutid = checkoutLog.checkoutid;
                this.userid = checkoutLog.userid;
                this.hashed_device = checkoutLog.hashed_device;
                this.ctime = checkoutLog.ctime;
                this.status = checkoutLog.status;
                this.flag = checkoutLog.flag;
                this.promotionid = checkoutLog.promotionid;
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder hashed_device(f fVar) {
            this.hashed_device = fVar;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder flag(Integer num) {
            this.flag = num;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public CheckoutLog build() {
            return new CheckoutLog(this);
        }
    }
}
