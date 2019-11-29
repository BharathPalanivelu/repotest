package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SendVcode extends Message {
    public static final Integer DEFAULT_ACTION_TYPE = 0;
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_BD_EMAIL = "";
    public static final Boolean DEFAULT_CHECK_OLD_PHONE = false;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_IS_PAYMENT_PASSWORD = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final String DEFAULT_LANG = "";
    public static final Boolean DEFAULT_LAZY = false;
    public static final String DEFAULT_M_TOKEN = "";
    public static final Boolean DEFAULT_NEW_OTP = false;
    public static final Integer DEFAULT_OPERATION = 0;
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer action_type;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String bd_email;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean check_old_phone;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_payment_password;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean lazy;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String m_token;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean new_otp;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public SendVcode(String str, String str2, Boolean bool, String str3, String str4, Boolean bool2, String str5, String str6, Integer num, String str7, Boolean bool3, String str8, Integer num2, Boolean bool4, Boolean bool5, Integer num3, Integer num4, String str9) {
        this.requestid = str;
        this.phone = str2;
        this.lazy = bool;
        this.country = str3;
        this.token = str4;
        this.is_payment_password = bool2;
        this.m_token = str5;
        this.bd_email = str6;
        this.action_type = num;
        this.otp_seed = str7;
        this.new_otp = bool3;
        this.lang = str8;
        this.appversion = num2;
        this.is_web = bool4;
        this.check_old_phone = bool5;
        this.operation = num3;
        this.platform = num4;
        this.client_ip = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SendVcode(com.shopee.protocol.action.SendVcode.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.phone
            java.lang.Boolean r4 = r0.lazy
            java.lang.String r5 = r0.country
            java.lang.String r6 = r0.token
            java.lang.Boolean r7 = r0.is_payment_password
            java.lang.String r8 = r0.m_token
            java.lang.String r9 = r0.bd_email
            java.lang.Integer r10 = r0.action_type
            java.lang.String r11 = r0.otp_seed
            java.lang.Boolean r12 = r0.new_otp
            java.lang.String r13 = r0.lang
            java.lang.Integer r14 = r0.appversion
            java.lang.Boolean r15 = r0.is_web
            r20 = r1
            java.lang.Boolean r1 = r0.check_old_phone
            r16 = r1
            java.lang.Integer r1 = r0.operation
            r17 = r1
            java.lang.Integer r1 = r0.platform
            r18 = r1
            java.lang.String r1 = r0.client_ip
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SendVcode.<init>(com.shopee.protocol.action.SendVcode$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendVcode)) {
            return false;
        }
        SendVcode sendVcode = (SendVcode) obj;
        if (!equals((Object) this.requestid, (Object) sendVcode.requestid) || !equals((Object) this.phone, (Object) sendVcode.phone) || !equals((Object) this.lazy, (Object) sendVcode.lazy) || !equals((Object) this.country, (Object) sendVcode.country) || !equals((Object) this.token, (Object) sendVcode.token) || !equals((Object) this.is_payment_password, (Object) sendVcode.is_payment_password) || !equals((Object) this.m_token, (Object) sendVcode.m_token) || !equals((Object) this.bd_email, (Object) sendVcode.bd_email) || !equals((Object) this.action_type, (Object) sendVcode.action_type) || !equals((Object) this.otp_seed, (Object) sendVcode.otp_seed) || !equals((Object) this.new_otp, (Object) sendVcode.new_otp) || !equals((Object) this.lang, (Object) sendVcode.lang) || !equals((Object) this.appversion, (Object) sendVcode.appversion) || !equals((Object) this.is_web, (Object) sendVcode.is_web) || !equals((Object) this.check_old_phone, (Object) sendVcode.check_old_phone) || !equals((Object) this.operation, (Object) sendVcode.operation) || !equals((Object) this.platform, (Object) sendVcode.platform) || !equals((Object) this.client_ip, (Object) sendVcode.client_ip)) {
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
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.lazy;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.token;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_payment_password;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str5 = this.m_token;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.bd_email;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.action_type;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        String str7 = this.otp_seed;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool3 = this.new_otp;
        int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str8 = this.lang;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num2 = this.appversion;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool4 = this.is_web;
        int hashCode14 = (hashCode13 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.check_old_phone;
        int hashCode15 = (hashCode14 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Integer num3 = this.operation;
        int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.platform;
        int hashCode17 = (hashCode16 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str9 = this.client_ip;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SendVcode> {
        public Integer action_type;
        public Integer appversion;
        public String bd_email;
        public Boolean check_old_phone;
        public String client_ip;
        public String country;
        public Boolean is_payment_password;
        public Boolean is_web;
        public String lang;
        public Boolean lazy;
        public String m_token;
        public Boolean new_otp;
        public Integer operation;
        public String otp_seed;
        public String phone;
        public Integer platform;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SendVcode sendVcode) {
            super(sendVcode);
            if (sendVcode != null) {
                this.requestid = sendVcode.requestid;
                this.phone = sendVcode.phone;
                this.lazy = sendVcode.lazy;
                this.country = sendVcode.country;
                this.token = sendVcode.token;
                this.is_payment_password = sendVcode.is_payment_password;
                this.m_token = sendVcode.m_token;
                this.bd_email = sendVcode.bd_email;
                this.action_type = sendVcode.action_type;
                this.otp_seed = sendVcode.otp_seed;
                this.new_otp = sendVcode.new_otp;
                this.lang = sendVcode.lang;
                this.appversion = sendVcode.appversion;
                this.is_web = sendVcode.is_web;
                this.check_old_phone = sendVcode.check_old_phone;
                this.operation = sendVcode.operation;
                this.platform = sendVcode.platform;
                this.client_ip = sendVcode.client_ip;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder lazy(Boolean bool) {
            this.lazy = bool;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_payment_password(Boolean bool) {
            this.is_payment_password = bool;
            return this;
        }

        public Builder m_token(String str) {
            this.m_token = str;
            return this;
        }

        public Builder bd_email(String str) {
            this.bd_email = str;
            return this;
        }

        public Builder action_type(Integer num) {
            this.action_type = num;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder new_otp(Boolean bool) {
            this.new_otp = bool;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder is_web(Boolean bool) {
            this.is_web = bool;
            return this;
        }

        public Builder check_old_phone(Boolean bool) {
            this.check_old_phone = bool;
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public SendVcode build() {
            checkRequiredFields();
            return new SendVcode(this);
        }
    }
}
