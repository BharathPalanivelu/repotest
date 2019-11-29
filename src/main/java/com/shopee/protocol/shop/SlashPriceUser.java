package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceUser extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_SLASH_COUNT = 0;
    public static final Integer DEFAULT_SLASH_LIMIT_EXPIRY_DATE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer slash_count;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer slash_limit_expiry_date;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public SlashPriceUser(Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.id = num;
        this.userid = num2;
        this.phone = str;
        this.slash_count = num3;
        this.slash_limit_expiry_date = num4;
        this.ctime = num5;
        this.mtime = num6;
    }

    private SlashPriceUser(Builder builder) {
        this(builder.id, builder.userid, builder.phone, builder.slash_count, builder.slash_limit_expiry_date, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceUser)) {
            return false;
        }
        SlashPriceUser slashPriceUser = (SlashPriceUser) obj;
        if (!equals((Object) this.id, (Object) slashPriceUser.id) || !equals((Object) this.userid, (Object) slashPriceUser.userid) || !equals((Object) this.phone, (Object) slashPriceUser.phone) || !equals((Object) this.slash_count, (Object) slashPriceUser.slash_count) || !equals((Object) this.slash_limit_expiry_date, (Object) slashPriceUser.slash_limit_expiry_date) || !equals((Object) this.ctime, (Object) slashPriceUser.ctime) || !equals((Object) this.mtime, (Object) slashPriceUser.mtime)) {
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
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.phone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.slash_count;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.slash_limit_expiry_date;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceUser> {
        public Integer ctime;
        public Integer id;
        public Integer mtime;
        public String phone;
        public Integer slash_count;
        public Integer slash_limit_expiry_date;
        public Integer userid;

        public Builder() {
        }

        public Builder(SlashPriceUser slashPriceUser) {
            super(slashPriceUser);
            if (slashPriceUser != null) {
                this.id = slashPriceUser.id;
                this.userid = slashPriceUser.userid;
                this.phone = slashPriceUser.phone;
                this.slash_count = slashPriceUser.slash_count;
                this.slash_limit_expiry_date = slashPriceUser.slash_limit_expiry_date;
                this.ctime = slashPriceUser.ctime;
                this.mtime = slashPriceUser.mtime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder slash_count(Integer num) {
            this.slash_count = num;
            return this;
        }

        public Builder slash_limit_expiry_date(Integer num) {
            this.slash_limit_expiry_date = num;
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

        public SlashPriceUser build() {
            return new SlashPriceUser(this);
        }
    }
}
