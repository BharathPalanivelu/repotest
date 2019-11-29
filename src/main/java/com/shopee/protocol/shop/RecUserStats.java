package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RecUserStats extends Message {
    public static final String DEFAULT_CATEGORY = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_VALUE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String category;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer value;

    public RecUserStats(Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, Integer num5) {
        this.id = num;
        this.shopid = num2;
        this.userid = num3;
        this.country = str;
        this.category = str2;
        this.ctime = num4;
        this.value = num5;
    }

    private RecUserStats(Builder builder) {
        this(builder.id, builder.shopid, builder.userid, builder.country, builder.category, builder.ctime, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecUserStats)) {
            return false;
        }
        RecUserStats recUserStats = (RecUserStats) obj;
        if (!equals((Object) this.id, (Object) recUserStats.id) || !equals((Object) this.shopid, (Object) recUserStats.shopid) || !equals((Object) this.userid, (Object) recUserStats.userid) || !equals((Object) this.country, (Object) recUserStats.country) || !equals((Object) this.category, (Object) recUserStats.category) || !equals((Object) this.ctime, (Object) recUserStats.ctime) || !equals((Object) this.value, (Object) recUserStats.value)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.category;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.value;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecUserStats> {
        public String category;
        public String country;
        public Integer ctime;
        public Integer id;
        public Integer shopid;
        public Integer userid;
        public Integer value;

        public Builder() {
        }

        public Builder(RecUserStats recUserStats) {
            super(recUserStats);
            if (recUserStats != null) {
                this.id = recUserStats.id;
                this.shopid = recUserStats.shopid;
                this.userid = recUserStats.userid;
                this.country = recUserStats.country;
                this.category = recUserStats.category;
                this.ctime = recUserStats.ctime;
                this.value = recUserStats.value;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder category(String str) {
            this.category = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public RecUserStats build() {
            return new RecUserStats(this);
        }
    }
}
