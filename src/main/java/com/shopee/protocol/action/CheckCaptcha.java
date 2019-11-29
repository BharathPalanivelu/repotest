package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckCaptcha extends Message {
    public static final String DEFAULT_CAPTCHA = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_PROVIDER = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String captcha;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String provider;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String type;

    public CheckCaptcha(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.requestid = str;
        this.key = str2;
        this.captcha = str3;
        this.email = str4;
        this.country = str5;
        this.provider = str6;
        this.type = str7;
    }

    private CheckCaptcha(Builder builder) {
        this(builder.requestid, builder.key, builder.captcha, builder.email, builder.country, builder.provider, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckCaptcha)) {
            return false;
        }
        CheckCaptcha checkCaptcha = (CheckCaptcha) obj;
        if (!equals((Object) this.requestid, (Object) checkCaptcha.requestid) || !equals((Object) this.key, (Object) checkCaptcha.key) || !equals((Object) this.captcha, (Object) checkCaptcha.captcha) || !equals((Object) this.email, (Object) checkCaptcha.email) || !equals((Object) this.country, (Object) checkCaptcha.country) || !equals((Object) this.provider, (Object) checkCaptcha.provider) || !equals((Object) this.type, (Object) checkCaptcha.type)) {
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
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.captcha;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.provider;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.type;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckCaptcha> {
        public String captcha;
        public String country;
        public String email;
        public String key;
        public String provider;
        public String requestid;
        public String type;

        public Builder() {
        }

        public Builder(CheckCaptcha checkCaptcha) {
            super(checkCaptcha);
            if (checkCaptcha != null) {
                this.requestid = checkCaptcha.requestid;
                this.key = checkCaptcha.key;
                this.captcha = checkCaptcha.captcha;
                this.email = checkCaptcha.email;
                this.country = checkCaptcha.country;
                this.provider = checkCaptcha.provider;
                this.type = checkCaptcha.type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder captcha(String str) {
            this.captcha = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder provider(String str) {
            this.provider = str;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public CheckCaptcha build() {
            return new CheckCaptcha(this);
        }
    }
}
