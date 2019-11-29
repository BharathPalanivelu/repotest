package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Referral extends Message {
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_REFERRAL_ID = 0;
    public static final Integer DEFAULT_REFERRAL_USERID = 0;
    public static final Integer DEFAULT_REFERRER_USERID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer referral_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer referral_userid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer referrer_userid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public Referral(Integer num, Integer num2, Integer num3, String str, Integer num4, Long l, Integer num5, Integer num6, String str2, f fVar) {
        this.referral_id = num;
        this.referral_userid = num2;
        this.referrer_userid = num3;
        this.phone = str;
        this.status = num4;
        this.coin_earn = l;
        this.ctime = num5;
        this.mtime = num6;
        this.country = str2;
        this.extinfo = fVar;
    }

    private Referral(Builder builder) {
        this(builder.referral_id, builder.referral_userid, builder.referrer_userid, builder.phone, builder.status, builder.coin_earn, builder.ctime, builder.mtime, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Referral)) {
            return false;
        }
        Referral referral = (Referral) obj;
        if (!equals((Object) this.referral_id, (Object) referral.referral_id) || !equals((Object) this.referral_userid, (Object) referral.referral_userid) || !equals((Object) this.referrer_userid, (Object) referral.referrer_userid) || !equals((Object) this.phone, (Object) referral.phone) || !equals((Object) this.status, (Object) referral.status) || !equals((Object) this.coin_earn, (Object) referral.coin_earn) || !equals((Object) this.ctime, (Object) referral.ctime) || !equals((Object) this.mtime, (Object) referral.mtime) || !equals((Object) this.country, (Object) referral.country) || !equals((Object) this.extinfo, (Object) referral.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.referral_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.referral_userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.referrer_userid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.phone;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l = this.coin_earn;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Referral> {
        public Long coin_earn;
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer mtime;
        public String phone;
        public Integer referral_id;
        public Integer referral_userid;
        public Integer referrer_userid;
        public Integer status;

        public Builder() {
        }

        public Builder(Referral referral) {
            super(referral);
            if (referral != null) {
                this.referral_id = referral.referral_id;
                this.referral_userid = referral.referral_userid;
                this.referrer_userid = referral.referrer_userid;
                this.phone = referral.phone;
                this.status = referral.status;
                this.coin_earn = referral.coin_earn;
                this.ctime = referral.ctime;
                this.mtime = referral.mtime;
                this.country = referral.country;
                this.extinfo = referral.extinfo;
            }
        }

        public Builder referral_id(Integer num) {
            this.referral_id = num;
            return this;
        }

        public Builder referral_userid(Integer num) {
            this.referral_userid = num;
            return this;
        }

        public Builder referrer_userid(Integer num) {
            this.referrer_userid = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Referral build() {
            return new Referral(this);
        }
    }
}
