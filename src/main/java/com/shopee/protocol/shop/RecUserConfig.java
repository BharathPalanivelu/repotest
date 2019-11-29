package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RecUserConfig extends Message {
    public static final String DEFAULT_ALGO_NAME = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_FNAME = "";
    public static final Integer DEFAULT_FVALUE = 0;
    public static final Integer DEFAULT_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String algo_name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String fname;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer fvalue;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;

    public RecUserConfig(Integer num, String str, String str2, String str3, Integer num2) {
        this.id = num;
        this.fname = str;
        this.algo_name = str2;
        this.country = str3;
        this.fvalue = num2;
    }

    private RecUserConfig(Builder builder) {
        this(builder.id, builder.fname, builder.algo_name, builder.country, builder.fvalue);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecUserConfig)) {
            return false;
        }
        RecUserConfig recUserConfig = (RecUserConfig) obj;
        if (!equals((Object) this.id, (Object) recUserConfig.id) || !equals((Object) this.fname, (Object) recUserConfig.fname) || !equals((Object) this.algo_name, (Object) recUserConfig.algo_name) || !equals((Object) this.country, (Object) recUserConfig.country) || !equals((Object) this.fvalue, (Object) recUserConfig.fvalue)) {
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
        String str = this.fname;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.algo_name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.fvalue;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecUserConfig> {
        public String algo_name;
        public String country;
        public String fname;
        public Integer fvalue;
        public Integer id;

        public Builder() {
        }

        public Builder(RecUserConfig recUserConfig) {
            super(recUserConfig);
            if (recUserConfig != null) {
                this.id = recUserConfig.id;
                this.fname = recUserConfig.fname;
                this.algo_name = recUserConfig.algo_name;
                this.country = recUserConfig.country;
                this.fvalue = recUserConfig.fvalue;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder fname(String str) {
            this.fname = str;
            return this;
        }

        public Builder algo_name(String str) {
            this.algo_name = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder fvalue(Integer num) {
            this.fvalue = num;
            return this;
        }

        public RecUserConfig build() {
            return new RecUserConfig(this);
        }
    }
}
