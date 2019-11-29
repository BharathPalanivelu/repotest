package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BindAccount extends Message {
    public static final String DEFAULT_BK_ACCESS_TOKEN = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DECISION_TOKEN = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_FB_ACCESS_TOKEN = "";
    public static final String DEFAULT_LINE_ACCESS_TOKEN = "";
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_OTP_TOKEN = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VCODE = "";
    public static final String DEFAULT_VERIFY_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String bk_access_token;
    @ProtoField(tag = 8)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String decision_token;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String fb_access_token;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String line_access_token;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String otp_token;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 15)
    public final RequestMeta request_meta;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String vcode;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String verify_token;

    public BindAccount(String str, String str2, String str3, String str4, String str5, String str6, String str7, BackendParam backendParam, String str8, String str9, String str10, String str11, String str12, String str13, RequestMeta requestMeta, String str14) {
        this.requestid = str;
        this.phone = str2;
        this.vcode = str3;
        this.email = str4;
        this.password = str5;
        this.fb_access_token = str6;
        this.token = str7;
        this.bparam = backendParam;
        this.country = str8;
        this.bk_access_token = str9;
        this.otp_token = str10;
        this.otp_seed = str11;
        this.verify_token = str12;
        this.line_access_token = str13;
        this.request_meta = requestMeta;
        this.decision_token = str14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BindAccount(com.shopee.protocol.action.BindAccount.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.phone
            java.lang.String r4 = r0.vcode
            java.lang.String r5 = r0.email
            java.lang.String r6 = r0.password
            java.lang.String r7 = r0.fb_access_token
            java.lang.String r8 = r0.token
            com.shopee.protocol.action.BackendParam r9 = r0.bparam
            java.lang.String r10 = r0.country
            java.lang.String r11 = r0.bk_access_token
            java.lang.String r12 = r0.otp_token
            java.lang.String r13 = r0.otp_seed
            java.lang.String r14 = r0.verify_token
            java.lang.String r15 = r0.line_access_token
            r18 = r1
            com.shopee.protocol.action.RequestMeta r1 = r0.request_meta
            r16 = r1
            java.lang.String r1 = r0.decision_token
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.BindAccount.<init>(com.shopee.protocol.action.BindAccount$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BindAccount)) {
            return false;
        }
        BindAccount bindAccount = (BindAccount) obj;
        if (!equals((Object) this.requestid, (Object) bindAccount.requestid) || !equals((Object) this.phone, (Object) bindAccount.phone) || !equals((Object) this.vcode, (Object) bindAccount.vcode) || !equals((Object) this.email, (Object) bindAccount.email) || !equals((Object) this.password, (Object) bindAccount.password) || !equals((Object) this.fb_access_token, (Object) bindAccount.fb_access_token) || !equals((Object) this.token, (Object) bindAccount.token) || !equals((Object) this.bparam, (Object) bindAccount.bparam) || !equals((Object) this.country, (Object) bindAccount.country) || !equals((Object) this.bk_access_token, (Object) bindAccount.bk_access_token) || !equals((Object) this.otp_token, (Object) bindAccount.otp_token) || !equals((Object) this.otp_seed, (Object) bindAccount.otp_seed) || !equals((Object) this.verify_token, (Object) bindAccount.verify_token) || !equals((Object) this.line_access_token, (Object) bindAccount.line_access_token) || !equals((Object) this.request_meta, (Object) bindAccount.request_meta) || !equals((Object) this.decision_token, (Object) bindAccount.decision_token)) {
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
        String str3 = this.vcode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.password;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.fb_access_token;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.token;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode8 = (hashCode7 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str8 = this.country;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.bk_access_token;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.otp_token;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.otp_seed;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.verify_token;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.line_access_token;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 37;
        RequestMeta requestMeta = this.request_meta;
        int hashCode15 = (hashCode14 + (requestMeta != null ? requestMeta.hashCode() : 0)) * 37;
        String str14 = this.decision_token;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BindAccount> {
        public String bk_access_token;
        public BackendParam bparam;
        public String country;
        public String decision_token;
        public String email;
        public String fb_access_token;
        public String line_access_token;
        public String otp_seed;
        public String otp_token;
        public String password;
        public String phone;
        public RequestMeta request_meta;
        public String requestid;
        public String token;
        public String vcode;
        public String verify_token;

        public Builder() {
        }

        public Builder(BindAccount bindAccount) {
            super(bindAccount);
            if (bindAccount != null) {
                this.requestid = bindAccount.requestid;
                this.phone = bindAccount.phone;
                this.vcode = bindAccount.vcode;
                this.email = bindAccount.email;
                this.password = bindAccount.password;
                this.fb_access_token = bindAccount.fb_access_token;
                this.token = bindAccount.token;
                this.bparam = bindAccount.bparam;
                this.country = bindAccount.country;
                this.bk_access_token = bindAccount.bk_access_token;
                this.otp_token = bindAccount.otp_token;
                this.otp_seed = bindAccount.otp_seed;
                this.verify_token = bindAccount.verify_token;
                this.line_access_token = bindAccount.line_access_token;
                this.request_meta = bindAccount.request_meta;
                this.decision_token = bindAccount.decision_token;
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

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder fb_access_token(String str) {
            this.fb_access_token = str;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder bk_access_token(String str) {
            this.bk_access_token = str;
            return this;
        }

        public Builder otp_token(String str) {
            this.otp_token = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder verify_token(String str) {
            this.verify_token = str;
            return this;
        }

        public Builder line_access_token(String str) {
            this.line_access_token = str;
            return this;
        }

        public Builder request_meta(RequestMeta requestMeta) {
            this.request_meta = requestMeta;
            return this;
        }

        public Builder decision_token(String str) {
            this.decision_token = str;
            return this;
        }

        public BindAccount build() {
            return new BindAccount(this);
        }
    }
}
