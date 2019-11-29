package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetAccount extends Message {
    public static final String DEFAULT_ACTION = "";
    public static final Integer DEFAULT_BANKACC_VERIFIED = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Boolean DEFAULT_NOT_MERGE_EXTINFO = false;
    public static final Boolean DEFAULT_PHONE_PUBLIC = false;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 100, type = Message.Datatype.STRING)
    public final String action;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer bankacc_verified;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean not_merge_extinfo;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean phone_public;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String user_name;

    public SetAccount(String str, String str2, BackendParam backendParam, String str3, String str4, Boolean bool, Integer num, f fVar, Integer num2, Integer num3, Boolean bool2, String str5) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.user_name = str3;
        this.portrait = str4;
        this.phone_public = bool;
        this.cb_option = num;
        this.extinfo = fVar;
        this.status = num2;
        this.bankacc_verified = num3;
        this.not_merge_extinfo = bool2;
        this.action = str5;
    }

    private SetAccount(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.user_name, builder.portrait, builder.phone_public, builder.cb_option, builder.extinfo, builder.status, builder.bankacc_verified, builder.not_merge_extinfo, builder.action);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAccount)) {
            return false;
        }
        SetAccount setAccount = (SetAccount) obj;
        if (!equals((Object) this.requestid, (Object) setAccount.requestid) || !equals((Object) this.token, (Object) setAccount.token) || !equals((Object) this.bparam, (Object) setAccount.bparam) || !equals((Object) this.user_name, (Object) setAccount.user_name) || !equals((Object) this.portrait, (Object) setAccount.portrait) || !equals((Object) this.phone_public, (Object) setAccount.phone_public) || !equals((Object) this.cb_option, (Object) setAccount.cb_option) || !equals((Object) this.extinfo, (Object) setAccount.extinfo) || !equals((Object) this.status, (Object) setAccount.status) || !equals((Object) this.bankacc_verified, (Object) setAccount.bankacc_verified) || !equals((Object) this.not_merge_extinfo, (Object) setAccount.not_merge_extinfo) || !equals((Object) this.action, (Object) setAccount.action)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str3 = this.user_name;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.portrait;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.phone_public;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.cb_option;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.bankacc_verified;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.not_merge_extinfo;
        int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str5 = this.action;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAccount> {
        public String action;
        public Integer bankacc_verified;
        public BackendParam bparam;
        public Integer cb_option;
        public f extinfo;
        public Boolean not_merge_extinfo;
        public Boolean phone_public;
        public String portrait;
        public String requestid;
        public Integer status;
        public String token;
        public String user_name;

        public Builder() {
        }

        public Builder(SetAccount setAccount) {
            super(setAccount);
            if (setAccount != null) {
                this.requestid = setAccount.requestid;
                this.token = setAccount.token;
                this.bparam = setAccount.bparam;
                this.user_name = setAccount.user_name;
                this.portrait = setAccount.portrait;
                this.phone_public = setAccount.phone_public;
                this.cb_option = setAccount.cb_option;
                this.extinfo = setAccount.extinfo;
                this.status = setAccount.status;
                this.bankacc_verified = setAccount.bankacc_verified;
                this.not_merge_extinfo = setAccount.not_merge_extinfo;
                this.action = setAccount.action;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder user_name(String str) {
            this.user_name = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder phone_public(Boolean bool) {
            this.phone_public = bool;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
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

        public Builder not_merge_extinfo(Boolean bool) {
            this.not_merge_extinfo = bool;
            return this;
        }

        public Builder action(String str) {
            this.action = str;
            return this;
        }

        public SetAccount build() {
            return new SetAccount(this);
        }
    }
}
