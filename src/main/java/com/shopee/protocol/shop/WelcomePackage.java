package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WelcomePackage extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DATA = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f data;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public WelcomePackage(Integer num, Integer num2, f fVar, String str, Integer num3, Integer num4) {
        this.id = num;
        this.type = num2;
        this.data = fVar;
        this.country = str;
        this.mtime = num3;
        this.ctime = num4;
    }

    private WelcomePackage(Builder builder) {
        this(builder.id, builder.type, builder.data, builder.country, builder.mtime, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WelcomePackage)) {
            return false;
        }
        WelcomePackage welcomePackage = (WelcomePackage) obj;
        if (!equals((Object) this.id, (Object) welcomePackage.id) || !equals((Object) this.type, (Object) welcomePackage.type) || !equals((Object) this.data, (Object) welcomePackage.data) || !equals((Object) this.country, (Object) welcomePackage.country) || !equals((Object) this.mtime, (Object) welcomePackage.mtime) || !equals((Object) this.ctime, (Object) welcomePackage.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.data;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WelcomePackage> {
        public String country;
        public Integer ctime;
        public f data;
        public Integer id;
        public Integer mtime;
        public Integer type;

        public Builder() {
        }

        public Builder(WelcomePackage welcomePackage) {
            super(welcomePackage);
            if (welcomePackage != null) {
                this.id = welcomePackage.id;
                this.type = welcomePackage.type;
                this.data = welcomePackage.data;
                this.country = welcomePackage.country;
                this.mtime = welcomePackage.mtime;
                this.ctime = welcomePackage.ctime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder data(f fVar) {
            this.data = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public WelcomePackage build() {
            return new WelcomePackage(this);
        }
    }
}
