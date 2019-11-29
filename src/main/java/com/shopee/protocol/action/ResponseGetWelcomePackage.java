package com.shopee.protocol.action;

import com.shopee.protocol.shop.WelcomePackageExtInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetWelcomePackage extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final WelcomePackageExtInfo data;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetWelcomePackage(String str, Integer num, String str2, WelcomePackageExtInfo welcomePackageExtInfo) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.data = welcomePackageExtInfo;
    }

    private ResponseGetWelcomePackage(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetWelcomePackage)) {
            return false;
        }
        ResponseGetWelcomePackage responseGetWelcomePackage = (ResponseGetWelcomePackage) obj;
        if (!equals((Object) this.requestid, (Object) responseGetWelcomePackage.requestid) || !equals((Object) this.errcode, (Object) responseGetWelcomePackage.errcode) || !equals((Object) this.debug_msg, (Object) responseGetWelcomePackage.debug_msg) || !equals((Object) this.data, (Object) responseGetWelcomePackage.data)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        WelcomePackageExtInfo welcomePackageExtInfo = this.data;
        if (welcomePackageExtInfo != null) {
            i2 = welcomePackageExtInfo.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetWelcomePackage> {
        public WelcomePackageExtInfo data;
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetWelcomePackage responseGetWelcomePackage) {
            super(responseGetWelcomePackage);
            if (responseGetWelcomePackage != null) {
                this.requestid = responseGetWelcomePackage.requestid;
                this.errcode = responseGetWelcomePackage.errcode;
                this.debug_msg = responseGetWelcomePackage.debug_msg;
                this.data = responseGetWelcomePackage.data;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder data(WelcomePackageExtInfo welcomePackageExtInfo) {
            this.data = welcomePackageExtInfo;
            return this;
        }

        public ResponseGetWelcomePackage build() {
            return new ResponseGetWelcomePackage(this);
        }
    }
}
