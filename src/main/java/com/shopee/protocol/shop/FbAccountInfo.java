package com.shopee.protocol.shop;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FbAccountInfo extends Message {
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_FBID = "";
    public static final String DEFAULT_FIRST_NAME = "";
    public static final Integer DEFAULT_FRIENDS_COUNT = 0;
    public static final String DEFAULT_GENDER = "";
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_LAST_NAME = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_NAME = "";
    public static final Float DEFAULT_TIMEZONE = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
    public static final String DEFAULT_UPDATED_TIME = "";
    public static final Boolean DEFAULT_VERIFIED = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String fbid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String first_name;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer friends_count;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String gender;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String last_name;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String locale;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 9, type = Message.Datatype.FLOAT)
    public final Float timezone;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String updated_time;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean verified;

    public FbAccountInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Float f2, String str9, Boolean bool, Integer num, Long l) {
        this.fbid = str;
        this.email = str2;
        this.name = str3;
        this.first_name = str4;
        this.last_name = str5;
        this.gender = str6;
        this.link = str7;
        this.locale = str8;
        this.timezone = f2;
        this.updated_time = str9;
        this.verified = bool;
        this.friends_count = num;
        this.id = l;
    }

    private FbAccountInfo(Builder builder) {
        this(builder.fbid, builder.email, builder.name, builder.first_name, builder.last_name, builder.gender, builder.link, builder.locale, builder.timezone, builder.updated_time, builder.verified, builder.friends_count, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FbAccountInfo)) {
            return false;
        }
        FbAccountInfo fbAccountInfo = (FbAccountInfo) obj;
        if (!equals((Object) this.fbid, (Object) fbAccountInfo.fbid) || !equals((Object) this.email, (Object) fbAccountInfo.email) || !equals((Object) this.name, (Object) fbAccountInfo.name) || !equals((Object) this.first_name, (Object) fbAccountInfo.first_name) || !equals((Object) this.last_name, (Object) fbAccountInfo.last_name) || !equals((Object) this.gender, (Object) fbAccountInfo.gender) || !equals((Object) this.link, (Object) fbAccountInfo.link) || !equals((Object) this.locale, (Object) fbAccountInfo.locale) || !equals((Object) this.timezone, (Object) fbAccountInfo.timezone) || !equals((Object) this.updated_time, (Object) fbAccountInfo.updated_time) || !equals((Object) this.verified, (Object) fbAccountInfo.verified) || !equals((Object) this.friends_count, (Object) fbAccountInfo.friends_count) || !equals((Object) this.id, (Object) fbAccountInfo.id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.fbid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.first_name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.last_name;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.gender;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.link;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.locale;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Float f2 = this.timezone;
        int hashCode9 = (hashCode8 + (f2 != null ? f2.hashCode() : 0)) * 37;
        String str9 = this.updated_time;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool = this.verified;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.friends_count;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FbAccountInfo> {
        public String email;
        public String fbid;
        public String first_name;
        public Integer friends_count;
        public String gender;
        public Long id;
        public String last_name;
        public String link;
        public String locale;
        public String name;
        public Float timezone;
        public String updated_time;
        public Boolean verified;

        public Builder() {
        }

        public Builder(FbAccountInfo fbAccountInfo) {
            super(fbAccountInfo);
            if (fbAccountInfo != null) {
                this.fbid = fbAccountInfo.fbid;
                this.email = fbAccountInfo.email;
                this.name = fbAccountInfo.name;
                this.first_name = fbAccountInfo.first_name;
                this.last_name = fbAccountInfo.last_name;
                this.gender = fbAccountInfo.gender;
                this.link = fbAccountInfo.link;
                this.locale = fbAccountInfo.locale;
                this.timezone = fbAccountInfo.timezone;
                this.updated_time = fbAccountInfo.updated_time;
                this.verified = fbAccountInfo.verified;
                this.friends_count = fbAccountInfo.friends_count;
                this.id = fbAccountInfo.id;
            }
        }

        public Builder fbid(String str) {
            this.fbid = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder first_name(String str) {
            this.first_name = str;
            return this;
        }

        public Builder last_name(String str) {
            this.last_name = str;
            return this;
        }

        public Builder gender(String str) {
            this.gender = str;
            return this;
        }

        public Builder link(String str) {
            this.link = str;
            return this;
        }

        public Builder locale(String str) {
            this.locale = str;
            return this;
        }

        public Builder timezone(Float f2) {
            this.timezone = f2;
            return this;
        }

        public Builder updated_time(String str) {
            this.updated_time = str;
            return this;
        }

        public Builder verified(Boolean bool) {
            this.verified = bool;
            return this;
        }

        public Builder friends_count(Integer num) {
            this.friends_count = num;
            return this;
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public FbAccountInfo build() {
            return new FbAccountInfo(this);
        }
    }
}
