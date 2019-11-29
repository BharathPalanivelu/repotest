package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VcodeHistory extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_IP = "";
    public static final Integer DEFAULT_OTP_CHANNEL = 0;
    public static final Integer DEFAULT_OTP_TYPE = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_SEND_TIME = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long id;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer otp_channel;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer otp_type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer send_time;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer source;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public VcodeHistory(Long l, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, String str2) {
        this.id = l;
        this.user_id = num;
        this.phone = str;
        this.otp_type = num2;
        this.send_time = num3;
        this.source = num4;
        this.otp_channel = num5;
        this.ip = str2;
    }

    private VcodeHistory(Builder builder) {
        this(builder.id, builder.user_id, builder.phone, builder.otp_type, builder.send_time, builder.source, builder.otp_channel, builder.ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VcodeHistory)) {
            return false;
        }
        VcodeHistory vcodeHistory = (VcodeHistory) obj;
        if (!equals((Object) this.id, (Object) vcodeHistory.id) || !equals((Object) this.user_id, (Object) vcodeHistory.user_id) || !equals((Object) this.phone, (Object) vcodeHistory.phone) || !equals((Object) this.otp_type, (Object) vcodeHistory.otp_type) || !equals((Object) this.send_time, (Object) vcodeHistory.send_time) || !equals((Object) this.source, (Object) vcodeHistory.source) || !equals((Object) this.otp_channel, (Object) vcodeHistory.otp_channel) || !equals((Object) this.ip, (Object) vcodeHistory.ip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.user_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.phone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.otp_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.send_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.source;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.otp_channel;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.ip;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VcodeHistory> {
        public Long id;
        public String ip;
        public Integer otp_channel;
        public Integer otp_type;
        public String phone;
        public Integer send_time;
        public Integer source;
        public Integer user_id;

        public Builder() {
        }

        public Builder(VcodeHistory vcodeHistory) {
            super(vcodeHistory);
            if (vcodeHistory != null) {
                this.id = vcodeHistory.id;
                this.user_id = vcodeHistory.user_id;
                this.phone = vcodeHistory.phone;
                this.otp_type = vcodeHistory.otp_type;
                this.send_time = vcodeHistory.send_time;
                this.source = vcodeHistory.source;
                this.otp_channel = vcodeHistory.otp_channel;
                this.ip = vcodeHistory.ip;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder otp_type(Integer num) {
            this.otp_type = num;
            return this;
        }

        public Builder send_time(Integer num) {
            this.send_time = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder otp_channel(Integer num) {
            this.otp_channel = num;
            return this;
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public VcodeHistory build() {
            return new VcodeHistory(this);
        }
    }
}
