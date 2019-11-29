package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DistributeVoucherUser extends Message {
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public DistributeVoucherUser(Integer num, Integer num2, Integer num3) {
        this.userid = num;
        this.start_time = num2;
        this.end_time = num3;
    }

    private DistributeVoucherUser(Builder builder) {
        this(builder.userid, builder.start_time, builder.end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DistributeVoucherUser)) {
            return false;
        }
        DistributeVoucherUser distributeVoucherUser = (DistributeVoucherUser) obj;
        if (!equals((Object) this.userid, (Object) distributeVoucherUser.userid) || !equals((Object) this.start_time, (Object) distributeVoucherUser.start_time) || !equals((Object) this.end_time, (Object) distributeVoucherUser.end_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.start_time;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DistributeVoucherUser> {
        public Integer end_time;
        public Integer start_time;
        public Integer userid;

        public Builder() {
        }

        public Builder(DistributeVoucherUser distributeVoucherUser) {
            super(distributeVoucherUser);
            if (distributeVoucherUser != null) {
                this.userid = distributeVoucherUser.userid;
                this.start_time = distributeVoucherUser.start_time;
                this.end_time = distributeVoucherUser.end_time;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public DistributeVoucherUser build() {
            return new DistributeVoucherUser(this);
        }
    }
}
