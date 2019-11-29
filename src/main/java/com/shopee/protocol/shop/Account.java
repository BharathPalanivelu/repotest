package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Account extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final Integer DEFAULT_BANKACC_VERIFIED = 0;
    public static final Integer DEFAULT_BEETALK_USERID = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_EMAIL_VERIFIED = false;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_FBID = "";
    public static final Integer DEFAULT_FOLLOWING_COUNT = 0;
    public static final Integer DEFAULT_INITED = 0;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final String DEFAULT_LANGUAGE = "";
    public static final Integer DEFAULT_LAST_LOGIN = 0;
    public static final Integer DEFAULT_LAST_LOGOUT = 0;
    public static final Integer DEFAULT_LIKED_COUNT = 0;
    public static final String DEFAULT_MACHINE_CODE = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PHONE = "";
    public static final Boolean DEFAULT_PHONE_PUBLIC = false;
    public static final Boolean DEFAULT_PHONE_VERIFIED = false;
    public static final Long DEFAULT_PN_OPTION = 0L;
    public static final f DEFAULT_PN_TOKEN = f.f32736b;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REMARK = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_WEB_LAST_LOGIN = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer bankacc_verified;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer beetalk_userid;
    @ProtoField(tag = 38, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 18, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean email_verified;
    @ProtoField(tag = 32, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String fbid;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer following_count;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer inited;
    @ProtoField(tag = 29, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String language;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer last_login;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer last_logout;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer liked_count;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String machine_code;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean phone_public;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean phone_verified;
    @ProtoField(tag = 19, type = Message.Datatype.UINT64)
    public final Long pn_option;
    @ProtoField(tag = 31, type = Message.Datatype.BYTES)
    public final f pn_token;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String remark;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer web_last_login;

    public Account(Integer num, Integer num2, String str, String str2, String str3, String str4, Integer num3, Integer num4, String str5, String str6, String str7, String str8, f fVar, Long l, String str9, Integer num5, String str10, Integer num6, Integer num7, Integer num8, Boolean bool, Boolean bool2, Integer num9, Boolean bool3, Boolean bool4, f fVar2, f fVar3, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15) {
        this.userid = num;
        this.shopid = num2;
        this.phone = str;
        this.email = str2;
        this.fbid = str3;
        this.password = str4;
        this.status = num3;
        this.bankacc_verified = num4;
        this.remark = str5;
        this.username = str6;
        this.portrait = str7;
        this.machine_code = str8;
        this.deviceid = fVar;
        this.pn_option = l;
        this.language = str9;
        this.appversion = num5;
        this.country = str10;
        this.ctime = num6;
        this.mtime = num7;
        this.following_count = num8;
        this.phone_verified = bool;
        this.email_verified = bool2;
        this.last_login = num9;
        this.is_seller = bool3;
        this.phone_public = bool4;
        this.pn_token = fVar2;
        this.extinfo = fVar3;
        this.liked_count = num10;
        this.web_last_login = num11;
        this.inited = num12;
        this.beetalk_userid = num13;
        this.last_logout = num14;
        this.cb_option = num15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Account(com.shopee.protocol.shop.Account.Builder r37) {
        /*
            r36 = this;
            r0 = r37
            r1 = r36
            java.lang.Integer r2 = r0.userid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.phone
            java.lang.String r5 = r0.email
            java.lang.String r6 = r0.fbid
            java.lang.String r7 = r0.password
            java.lang.Integer r8 = r0.status
            java.lang.Integer r9 = r0.bankacc_verified
            java.lang.String r10 = r0.remark
            java.lang.String r11 = r0.username
            java.lang.String r12 = r0.portrait
            java.lang.String r13 = r0.machine_code
            e.f r14 = r0.deviceid
            java.lang.Long r15 = r0.pn_option
            r35 = r1
            java.lang.String r1 = r0.language
            r16 = r1
            java.lang.Integer r1 = r0.appversion
            r17 = r1
            java.lang.String r1 = r0.country
            r18 = r1
            java.lang.Integer r1 = r0.ctime
            r19 = r1
            java.lang.Integer r1 = r0.mtime
            r20 = r1
            java.lang.Integer r1 = r0.following_count
            r21 = r1
            java.lang.Boolean r1 = r0.phone_verified
            r22 = r1
            java.lang.Boolean r1 = r0.email_verified
            r23 = r1
            java.lang.Integer r1 = r0.last_login
            r24 = r1
            java.lang.Boolean r1 = r0.is_seller
            r25 = r1
            java.lang.Boolean r1 = r0.phone_public
            r26 = r1
            e.f r1 = r0.pn_token
            r27 = r1
            e.f r1 = r0.extinfo
            r28 = r1
            java.lang.Integer r1 = r0.liked_count
            r29 = r1
            java.lang.Integer r1 = r0.web_last_login
            r30 = r1
            java.lang.Integer r1 = r0.inited
            r31 = r1
            java.lang.Integer r1 = r0.beetalk_userid
            r32 = r1
            java.lang.Integer r1 = r0.last_logout
            r33 = r1
            java.lang.Integer r1 = r0.cb_option
            r34 = r1
            r1 = r35
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r36.setBuilder(r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Account.<init>(com.shopee.protocol.shop.Account$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;
        if (!equals((Object) this.userid, (Object) account.userid) || !equals((Object) this.shopid, (Object) account.shopid) || !equals((Object) this.phone, (Object) account.phone) || !equals((Object) this.email, (Object) account.email) || !equals((Object) this.fbid, (Object) account.fbid) || !equals((Object) this.password, (Object) account.password) || !equals((Object) this.status, (Object) account.status) || !equals((Object) this.bankacc_verified, (Object) account.bankacc_verified) || !equals((Object) this.remark, (Object) account.remark) || !equals((Object) this.username, (Object) account.username) || !equals((Object) this.portrait, (Object) account.portrait) || !equals((Object) this.machine_code, (Object) account.machine_code) || !equals((Object) this.deviceid, (Object) account.deviceid) || !equals((Object) this.pn_option, (Object) account.pn_option) || !equals((Object) this.language, (Object) account.language) || !equals((Object) this.appversion, (Object) account.appversion) || !equals((Object) this.country, (Object) account.country) || !equals((Object) this.ctime, (Object) account.ctime) || !equals((Object) this.mtime, (Object) account.mtime) || !equals((Object) this.following_count, (Object) account.following_count) || !equals((Object) this.phone_verified, (Object) account.phone_verified) || !equals((Object) this.email_verified, (Object) account.email_verified) || !equals((Object) this.last_login, (Object) account.last_login) || !equals((Object) this.is_seller, (Object) account.is_seller) || !equals((Object) this.phone_public, (Object) account.phone_public) || !equals((Object) this.pn_token, (Object) account.pn_token) || !equals((Object) this.extinfo, (Object) account.extinfo) || !equals((Object) this.liked_count, (Object) account.liked_count) || !equals((Object) this.web_last_login, (Object) account.web_last_login) || !equals((Object) this.inited, (Object) account.inited) || !equals((Object) this.beetalk_userid, (Object) account.beetalk_userid) || !equals((Object) this.last_logout, (Object) account.last_logout) || !equals((Object) this.cb_option, (Object) account.cb_option)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.phone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.email;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.fbid;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.password;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.bankacc_verified;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str5 = this.remark;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.username;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.portrait;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.machine_code;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode13 = (hashCode12 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l = this.pn_option;
        int hashCode14 = (hashCode13 + (l != null ? l.hashCode() : 0)) * 37;
        String str9 = this.language;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num5 = this.appversion;
        int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str10 = this.country;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode18 = (hashCode17 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode19 = (hashCode18 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.following_count;
        int hashCode20 = (hashCode19 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool = this.phone_verified;
        int hashCode21 = (hashCode20 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.email_verified;
        int hashCode22 = (hashCode21 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num9 = this.last_login;
        int hashCode23 = (hashCode22 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_seller;
        int hashCode24 = (hashCode23 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.phone_public;
        int hashCode25 = (hashCode24 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        f fVar2 = this.pn_token;
        int hashCode26 = (hashCode25 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.extinfo;
        int hashCode27 = (hashCode26 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num10 = this.liked_count;
        int hashCode28 = (hashCode27 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.web_last_login;
        int hashCode29 = (hashCode28 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.inited;
        int hashCode30 = (hashCode29 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.beetalk_userid;
        int hashCode31 = (hashCode30 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.last_logout;
        int hashCode32 = (hashCode31 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.cb_option;
        if (num15 != null) {
            i2 = num15.hashCode();
        }
        int i3 = hashCode32 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Account> {
        public Integer appversion;
        public Integer bankacc_verified;
        public Integer beetalk_userid;
        public Integer cb_option;
        public String country;
        public Integer ctime;
        public f deviceid;
        public String email;
        public Boolean email_verified;
        public f extinfo;
        public String fbid;
        public Integer following_count;
        public Integer inited;
        public Boolean is_seller;
        public String language;
        public Integer last_login;
        public Integer last_logout;
        public Integer liked_count;
        public String machine_code;
        public Integer mtime;
        public String password;
        public String phone;
        public Boolean phone_public;
        public Boolean phone_verified;
        public Long pn_option;
        public f pn_token;
        public String portrait;
        public String remark;
        public Integer shopid;
        public Integer status;
        public Integer userid;
        public String username;
        public Integer web_last_login;

        public Builder() {
        }

        public Builder(Account account) {
            super(account);
            if (account != null) {
                this.userid = account.userid;
                this.shopid = account.shopid;
                this.phone = account.phone;
                this.email = account.email;
                this.fbid = account.fbid;
                this.password = account.password;
                this.status = account.status;
                this.bankacc_verified = account.bankacc_verified;
                this.remark = account.remark;
                this.username = account.username;
                this.portrait = account.portrait;
                this.machine_code = account.machine_code;
                this.deviceid = account.deviceid;
                this.pn_option = account.pn_option;
                this.language = account.language;
                this.appversion = account.appversion;
                this.country = account.country;
                this.ctime = account.ctime;
                this.mtime = account.mtime;
                this.following_count = account.following_count;
                this.phone_verified = account.phone_verified;
                this.email_verified = account.email_verified;
                this.last_login = account.last_login;
                this.is_seller = account.is_seller;
                this.phone_public = account.phone_public;
                this.pn_token = account.pn_token;
                this.extinfo = account.extinfo;
                this.liked_count = account.liked_count;
                this.web_last_login = account.web_last_login;
                this.inited = account.inited;
                this.beetalk_userid = account.beetalk_userid;
                this.last_logout = account.last_logout;
                this.cb_option = account.cb_option;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder fbid(String str) {
            this.fbid = str;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder bankacc_verified(Integer num) {
            this.bankacc_verified = num;
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder machine_code(String str) {
            this.machine_code = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder pn_option(Long l) {
            this.pn_option = l;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder following_count(Integer num) {
            this.following_count = num;
            return this;
        }

        public Builder phone_verified(Boolean bool) {
            this.phone_verified = bool;
            return this;
        }

        public Builder email_verified(Boolean bool) {
            this.email_verified = bool;
            return this;
        }

        public Builder last_login(Integer num) {
            this.last_login = num;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder phone_public(Boolean bool) {
            this.phone_public = bool;
            return this;
        }

        public Builder pn_token(f fVar) {
            this.pn_token = fVar;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder liked_count(Integer num) {
            this.liked_count = num;
            return this;
        }

        public Builder web_last_login(Integer num) {
            this.web_last_login = num;
            return this;
        }

        public Builder inited(Integer num) {
            this.inited = num;
            return this;
        }

        public Builder beetalk_userid(Integer num) {
            this.beetalk_userid = num;
            return this;
        }

        public Builder last_logout(Integer num) {
            this.last_logout = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
