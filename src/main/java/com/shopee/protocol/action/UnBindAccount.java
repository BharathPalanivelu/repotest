package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UnBindAccount extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_IS_UNBIND_BEETALK = false;
    public static final Boolean DEFAULT_IS_UNBIND_EMAIL = false;
    public static final Boolean DEFAULT_IS_UNBIND_FACEBOOK = false;
    public static final Boolean DEFAULT_IS_UNBIND_LINE = false;
    public static final Boolean DEFAULT_IS_UNBIND_PHONE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_unbind_beetalk;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_unbind_email;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_unbind_facebook;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean is_unbind_line;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_unbind_phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String token;

    public UnBindAccount(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, String str3, BackendParam backendParam, Boolean bool5) {
        this.requestid = str;
        this.is_unbind_phone = bool;
        this.is_unbind_facebook = bool2;
        this.is_unbind_email = bool3;
        this.is_unbind_beetalk = bool4;
        this.country = str2;
        this.token = str3;
        this.bparam = backendParam;
        this.is_unbind_line = bool5;
    }

    private UnBindAccount(Builder builder) {
        this(builder.requestid, builder.is_unbind_phone, builder.is_unbind_facebook, builder.is_unbind_email, builder.is_unbind_beetalk, builder.country, builder.token, builder.bparam, builder.is_unbind_line);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnBindAccount)) {
            return false;
        }
        UnBindAccount unBindAccount = (UnBindAccount) obj;
        if (!equals((Object) this.requestid, (Object) unBindAccount.requestid) || !equals((Object) this.is_unbind_phone, (Object) unBindAccount.is_unbind_phone) || !equals((Object) this.is_unbind_facebook, (Object) unBindAccount.is_unbind_facebook) || !equals((Object) this.is_unbind_email, (Object) unBindAccount.is_unbind_email) || !equals((Object) this.is_unbind_beetalk, (Object) unBindAccount.is_unbind_beetalk) || !equals((Object) this.country, (Object) unBindAccount.country) || !equals((Object) this.token, (Object) unBindAccount.token) || !equals((Object) this.bparam, (Object) unBindAccount.bparam) || !equals((Object) this.is_unbind_line, (Object) unBindAccount.is_unbind_line)) {
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
        Boolean bool = this.is_unbind_phone;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_unbind_facebook;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_unbind_email;
        int hashCode4 = (hashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.is_unbind_beetalk;
        int hashCode5 = (hashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode8 = (hashCode7 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool5 = this.is_unbind_line;
        if (bool5 != null) {
            i2 = bool5.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UnBindAccount> {
        public BackendParam bparam;
        public String country;
        public Boolean is_unbind_beetalk;
        public Boolean is_unbind_email;
        public Boolean is_unbind_facebook;
        public Boolean is_unbind_line;
        public Boolean is_unbind_phone;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(UnBindAccount unBindAccount) {
            super(unBindAccount);
            if (unBindAccount != null) {
                this.requestid = unBindAccount.requestid;
                this.is_unbind_phone = unBindAccount.is_unbind_phone;
                this.is_unbind_facebook = unBindAccount.is_unbind_facebook;
                this.is_unbind_email = unBindAccount.is_unbind_email;
                this.is_unbind_beetalk = unBindAccount.is_unbind_beetalk;
                this.country = unBindAccount.country;
                this.token = unBindAccount.token;
                this.bparam = unBindAccount.bparam;
                this.is_unbind_line = unBindAccount.is_unbind_line;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_unbind_phone(Boolean bool) {
            this.is_unbind_phone = bool;
            return this;
        }

        public Builder is_unbind_facebook(Boolean bool) {
            this.is_unbind_facebook = bool;
            return this;
        }

        public Builder is_unbind_email(Boolean bool) {
            this.is_unbind_email = bool;
            return this;
        }

        public Builder is_unbind_beetalk(Boolean bool) {
            this.is_unbind_beetalk = bool;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder is_unbind_line(Boolean bool) {
            this.is_unbind_line = bool;
            return this;
        }

        public UnBindAccount build() {
            return new UnBindAccount(this);
        }
    }
}
