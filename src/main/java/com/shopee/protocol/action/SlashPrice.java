package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPrice extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String vcode;

    public SlashPrice(String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, f fVar) {
        this.requestid = str;
        this.token = str2;
        this.phone = str3;
        this.vcode = str4;
        this.otp_seed = str5;
        this.activity_id = l;
        this.country = str6;
        this.nickname = str7;
        this.client_ip = str8;
        this.device_fingerprint = fVar;
    }

    private SlashPrice(Builder builder) {
        this(builder.requestid, builder.token, builder.phone, builder.vcode, builder.otp_seed, builder.activity_id, builder.country, builder.nickname, builder.client_ip, builder.device_fingerprint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPrice)) {
            return false;
        }
        SlashPrice slashPrice = (SlashPrice) obj;
        if (!equals((Object) this.requestid, (Object) slashPrice.requestid) || !equals((Object) this.token, (Object) slashPrice.token) || !equals((Object) this.phone, (Object) slashPrice.phone) || !equals((Object) this.vcode, (Object) slashPrice.vcode) || !equals((Object) this.otp_seed, (Object) slashPrice.otp_seed) || !equals((Object) this.activity_id, (Object) slashPrice.activity_id) || !equals((Object) this.country, (Object) slashPrice.country) || !equals((Object) this.nickname, (Object) slashPrice.nickname) || !equals((Object) this.client_ip, (Object) slashPrice.client_ip) || !equals((Object) this.device_fingerprint, (Object) slashPrice.device_fingerprint)) {
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
        String str3 = this.phone;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.vcode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.otp_seed;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l = this.activity_id;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str6 = this.country;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.nickname;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.client_ip;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        f fVar = this.device_fingerprint;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPrice> {
        public Long activity_id;
        public String client_ip;
        public String country;
        public f device_fingerprint;
        public String nickname;
        public String otp_seed;
        public String phone;
        public String requestid;
        public String token;
        public String vcode;

        public Builder() {
        }

        public Builder(SlashPrice slashPrice) {
            super(slashPrice);
            if (slashPrice != null) {
                this.requestid = slashPrice.requestid;
                this.token = slashPrice.token;
                this.phone = slashPrice.phone;
                this.vcode = slashPrice.vcode;
                this.otp_seed = slashPrice.otp_seed;
                this.activity_id = slashPrice.activity_id;
                this.country = slashPrice.country;
                this.nickname = slashPrice.nickname;
                this.client_ip = slashPrice.client_ip;
                this.device_fingerprint = slashPrice.device_fingerprint;
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

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public SlashPrice build() {
            return new SlashPrice(this);
        }
    }
}
