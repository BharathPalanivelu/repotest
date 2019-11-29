package com.shopee.protocol.action;

import com.shopee.protocol.shop.WelcomePackageExtInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetWelcomePackage extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_ONLY_UPDATE_PRICE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4)
    public final WelcomePackageExtInfo data;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean only_update_price;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public SetWelcomePackage(String str, String str2, Integer num, WelcomePackageExtInfo welcomePackageExtInfo, Boolean bool) {
        this.requestid = str;
        this.country = str2;
        this.type = num;
        this.data = welcomePackageExtInfo;
        this.only_update_price = bool;
    }

    private SetWelcomePackage(Builder builder) {
        this(builder.requestid, builder.country, builder.type, builder.data, builder.only_update_price);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetWelcomePackage)) {
            return false;
        }
        SetWelcomePackage setWelcomePackage = (SetWelcomePackage) obj;
        if (!equals((Object) this.requestid, (Object) setWelcomePackage.requestid) || !equals((Object) this.country, (Object) setWelcomePackage.country) || !equals((Object) this.type, (Object) setWelcomePackage.type) || !equals((Object) this.data, (Object) setWelcomePackage.data) || !equals((Object) this.only_update_price, (Object) setWelcomePackage.only_update_price)) {
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
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        WelcomePackageExtInfo welcomePackageExtInfo = this.data;
        int hashCode4 = (hashCode3 + (welcomePackageExtInfo != null ? welcomePackageExtInfo.hashCode() : 0)) * 37;
        Boolean bool = this.only_update_price;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetWelcomePackage> {
        public String country;
        public WelcomePackageExtInfo data;
        public Boolean only_update_price;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(SetWelcomePackage setWelcomePackage) {
            super(setWelcomePackage);
            if (setWelcomePackage != null) {
                this.requestid = setWelcomePackage.requestid;
                this.country = setWelcomePackage.country;
                this.type = setWelcomePackage.type;
                this.data = setWelcomePackage.data;
                this.only_update_price = setWelcomePackage.only_update_price;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder data(WelcomePackageExtInfo welcomePackageExtInfo) {
            this.data = welcomePackageExtInfo;
            return this;
        }

        public Builder only_update_price(Boolean bool) {
            this.only_update_price = bool;
            return this;
        }

        public SetWelcomePackage build() {
            return new SetWelcomePackage(this);
        }
    }
}
