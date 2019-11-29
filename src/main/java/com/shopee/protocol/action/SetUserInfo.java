package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.shopee.protocol.shop.DeviceExtinfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetUserInfo extends Message {
    public static final String DEFAULT_ACTION = "";
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final Integer DEFAULT_BANKACC_VERIFIED = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_MACHINE_CODE = "";
    public static final Boolean DEFAULT_NOT_MERGE_EXTINFO = false;
    public static final Boolean DEFAULT_PHONE_PUBLIC = false;
    public static final Long DEFAULT_PN_OPTION = 0L;
    public static final f DEFAULT_PN_TOKEN = f.f32736b;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 100, type = Message.Datatype.STRING)
    public final String action;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer bankacc_verified;
    @ProtoField(tag = 10)
    public final BackendParam bparam;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 22)
    public final DeviceExtinfo device_ext;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 21)
    public final DeviceExt ext;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String language;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String machine_code;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean not_merge_extinfo;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean phone_public;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long pn_option;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f pn_token;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String user_name;

    public SetUserInfo(String str, String str2, String str3, String str4, String str5, f fVar, Long l, String str6, Boolean bool, BackendParam backendParam, f fVar2, f fVar3, Integer num, Integer num2, Integer num3, Boolean bool2, String str7, Integer num4, DeviceExt deviceExt, DeviceExtinfo deviceExtinfo, String str8) {
        this.requestid = str;
        this.token = str2;
        this.country = str3;
        this.portrait = str4;
        this.machine_code = str5;
        this.deviceid = fVar;
        this.pn_option = l;
        this.language = str6;
        this.phone_public = bool;
        this.bparam = backendParam;
        this.pn_token = fVar2;
        this.extinfo = fVar3;
        this.status = num;
        this.bankacc_verified = num2;
        this.appversion = num3;
        this.not_merge_extinfo = bool2;
        this.user_name = str7;
        this.cb_option = num4;
        this.ext = deviceExt;
        this.device_ext = deviceExtinfo;
        this.action = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SetUserInfo(com.shopee.protocol.action.SetUserInfo.Builder r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.token
            java.lang.String r4 = r0.country
            java.lang.String r5 = r0.portrait
            java.lang.String r6 = r0.machine_code
            e.f r7 = r0.deviceid
            java.lang.Long r8 = r0.pn_option
            java.lang.String r9 = r0.language
            java.lang.Boolean r10 = r0.phone_public
            com.shopee.protocol.action.BackendParam r11 = r0.bparam
            e.f r12 = r0.pn_token
            e.f r13 = r0.extinfo
            java.lang.Integer r14 = r0.status
            java.lang.Integer r15 = r0.bankacc_verified
            r23 = r1
            java.lang.Integer r1 = r0.appversion
            r16 = r1
            java.lang.Boolean r1 = r0.not_merge_extinfo
            r17 = r1
            java.lang.String r1 = r0.user_name
            r18 = r1
            java.lang.Integer r1 = r0.cb_option
            r19 = r1
            com.shopee.protocol.shop.DeviceExt r1 = r0.ext
            r20 = r1
            com.shopee.protocol.shop.DeviceExtinfo r1 = r0.device_ext
            r21 = r1
            java.lang.String r1 = r0.action
            r22 = r1
            r1 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r24.setBuilder(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SetUserInfo.<init>(com.shopee.protocol.action.SetUserInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetUserInfo)) {
            return false;
        }
        SetUserInfo setUserInfo = (SetUserInfo) obj;
        if (!equals((Object) this.requestid, (Object) setUserInfo.requestid) || !equals((Object) this.token, (Object) setUserInfo.token) || !equals((Object) this.country, (Object) setUserInfo.country) || !equals((Object) this.portrait, (Object) setUserInfo.portrait) || !equals((Object) this.machine_code, (Object) setUserInfo.machine_code) || !equals((Object) this.deviceid, (Object) setUserInfo.deviceid) || !equals((Object) this.pn_option, (Object) setUserInfo.pn_option) || !equals((Object) this.language, (Object) setUserInfo.language) || !equals((Object) this.phone_public, (Object) setUserInfo.phone_public) || !equals((Object) this.bparam, (Object) setUserInfo.bparam) || !equals((Object) this.pn_token, (Object) setUserInfo.pn_token) || !equals((Object) this.extinfo, (Object) setUserInfo.extinfo) || !equals((Object) this.status, (Object) setUserInfo.status) || !equals((Object) this.bankacc_verified, (Object) setUserInfo.bankacc_verified) || !equals((Object) this.appversion, (Object) setUserInfo.appversion) || !equals((Object) this.not_merge_extinfo, (Object) setUserInfo.not_merge_extinfo) || !equals((Object) this.user_name, (Object) setUserInfo.user_name) || !equals((Object) this.cb_option, (Object) setUserInfo.cb_option) || !equals((Object) this.ext, (Object) setUserInfo.ext) || !equals((Object) this.device_ext, (Object) setUserInfo.device_ext) || !equals((Object) this.action, (Object) setUserInfo.action)) {
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
        String str3 = this.country;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.portrait;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.machine_code;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l = this.pn_option;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        String str6 = this.language;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Boolean bool = this.phone_public;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode10 = (hashCode9 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        f fVar2 = this.pn_token;
        int hashCode11 = (hashCode10 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.extinfo;
        int hashCode12 = (hashCode11 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode13 = (hashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.bankacc_verified;
        int hashCode14 = (hashCode13 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.appversion;
        int hashCode15 = (hashCode14 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.not_merge_extinfo;
        int hashCode16 = (hashCode15 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str7 = this.user_name;
        int hashCode17 = (hashCode16 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num4 = this.cb_option;
        int hashCode18 = (hashCode17 + (num4 != null ? num4.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode19 = (hashCode18 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        DeviceExtinfo deviceExtinfo = this.device_ext;
        int hashCode20 = (hashCode19 + (deviceExtinfo != null ? deviceExtinfo.hashCode() : 0)) * 37;
        String str8 = this.action;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode20 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetUserInfo> {
        public String action;
        public Integer appversion;
        public Integer bankacc_verified;
        public BackendParam bparam;
        public Integer cb_option;
        public String country;
        public DeviceExtinfo device_ext;
        public f deviceid;
        public DeviceExt ext;
        public f extinfo;
        public String language;
        public String machine_code;
        public Boolean not_merge_extinfo;
        public Boolean phone_public;
        public Long pn_option;
        public f pn_token;
        public String portrait;
        public String requestid;
        public Integer status;
        public String token;
        public String user_name;

        public Builder() {
        }

        public Builder(SetUserInfo setUserInfo) {
            super(setUserInfo);
            if (setUserInfo != null) {
                this.requestid = setUserInfo.requestid;
                this.token = setUserInfo.token;
                this.country = setUserInfo.country;
                this.portrait = setUserInfo.portrait;
                this.machine_code = setUserInfo.machine_code;
                this.deviceid = setUserInfo.deviceid;
                this.pn_option = setUserInfo.pn_option;
                this.language = setUserInfo.language;
                this.phone_public = setUserInfo.phone_public;
                this.bparam = setUserInfo.bparam;
                this.pn_token = setUserInfo.pn_token;
                this.extinfo = setUserInfo.extinfo;
                this.status = setUserInfo.status;
                this.bankacc_verified = setUserInfo.bankacc_verified;
                this.appversion = setUserInfo.appversion;
                this.not_merge_extinfo = setUserInfo.not_merge_extinfo;
                this.user_name = setUserInfo.user_name;
                this.cb_option = setUserInfo.cb_option;
                this.ext = setUserInfo.ext;
                this.device_ext = setUserInfo.device_ext;
                this.action = setUserInfo.action;
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

        public Builder country(String str) {
            this.country = str;
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

        public Builder phone_public(Boolean bool) {
            this.phone_public = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder bankacc_verified(Integer num) {
            this.bankacc_verified = num;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder not_merge_extinfo(Boolean bool) {
            this.not_merge_extinfo = bool;
            return this;
        }

        public Builder user_name(String str) {
            this.user_name = str;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder ext(DeviceExt deviceExt) {
            this.ext = deviceExt;
            return this;
        }

        public Builder device_ext(DeviceExtinfo deviceExtinfo) {
            this.device_ext = deviceExtinfo;
            return this;
        }

        public Builder action(String str) {
            this.action = str;
            return this;
        }

        public SetUserInfo build() {
            return new SetUserInfo(this);
        }
    }
}
