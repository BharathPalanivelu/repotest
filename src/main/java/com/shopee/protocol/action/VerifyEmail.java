package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VerifyEmail extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_UNSUB_NEWSLETTER = false;
    public static final String DEFAULT_VSTR = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean unsub_newsletter;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String vstr;

    public VerifyEmail(String str, String str2, String str3, String str4, Boolean bool) {
        this.requestid = str;
        this.email = str2;
        this.vstr = str3;
        this.country = str4;
        this.unsub_newsletter = bool;
    }

    private VerifyEmail(Builder builder) {
        this(builder.requestid, builder.email, builder.vstr, builder.country, builder.unsub_newsletter);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VerifyEmail)) {
            return false;
        }
        VerifyEmail verifyEmail = (VerifyEmail) obj;
        if (!equals((Object) this.requestid, (Object) verifyEmail.requestid) || !equals((Object) this.email, (Object) verifyEmail.email) || !equals((Object) this.vstr, (Object) verifyEmail.vstr) || !equals((Object) this.country, (Object) verifyEmail.country) || !equals((Object) this.unsub_newsletter, (Object) verifyEmail.unsub_newsletter)) {
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
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.vstr;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.unsub_newsletter;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VerifyEmail> {
        public String country;
        public String email;
        public String requestid;
        public Boolean unsub_newsletter;
        public String vstr;

        public Builder() {
        }

        public Builder(VerifyEmail verifyEmail) {
            super(verifyEmail);
            if (verifyEmail != null) {
                this.requestid = verifyEmail.requestid;
                this.email = verifyEmail.email;
                this.vstr = verifyEmail.vstr;
                this.country = verifyEmail.country;
                this.unsub_newsletter = verifyEmail.unsub_newsletter;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder vstr(String str) {
            this.vstr = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder unsub_newsletter(Boolean bool) {
            this.unsub_newsletter = bool;
            return this;
        }

        public VerifyEmail build() {
            checkRequiredFields();
            return new VerifyEmail(this);
        }
    }
}
