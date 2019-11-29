package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReferralCodeCounter extends Message {
    public static final Integer DEFAULT_COUNTER = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PREFIX = "";
    public static final Long DEFAULT_PROMOTIONID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer counter;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String prefix;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long promotionid;

    public ReferralCodeCounter(Long l, String str, Integer num, String str2, Integer num2, Integer num3, Long l2) {
        this.id = l;
        this.prefix = str;
        this.counter = num;
        this.country = str2;
        this.ctime = num2;
        this.mtime = num3;
        this.promotionid = l2;
    }

    private ReferralCodeCounter(Builder builder) {
        this(builder.id, builder.prefix, builder.counter, builder.country, builder.ctime, builder.mtime, builder.promotionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReferralCodeCounter)) {
            return false;
        }
        ReferralCodeCounter referralCodeCounter = (ReferralCodeCounter) obj;
        if (!equals((Object) this.id, (Object) referralCodeCounter.id) || !equals((Object) this.prefix, (Object) referralCodeCounter.prefix) || !equals((Object) this.counter, (Object) referralCodeCounter.counter) || !equals((Object) this.country, (Object) referralCodeCounter.country) || !equals((Object) this.ctime, (Object) referralCodeCounter.ctime) || !equals((Object) this.mtime, (Object) referralCodeCounter.mtime) || !equals((Object) this.promotionid, (Object) referralCodeCounter.promotionid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.prefix;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.counter;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.promotionid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReferralCodeCounter> {
        public Integer counter;
        public String country;
        public Integer ctime;
        public Long id;
        public Integer mtime;
        public String prefix;
        public Long promotionid;

        public Builder() {
        }

        public Builder(ReferralCodeCounter referralCodeCounter) {
            super(referralCodeCounter);
            if (referralCodeCounter != null) {
                this.id = referralCodeCounter.id;
                this.prefix = referralCodeCounter.prefix;
                this.counter = referralCodeCounter.counter;
                this.country = referralCodeCounter.country;
                this.ctime = referralCodeCounter.ctime;
                this.mtime = referralCodeCounter.mtime;
                this.promotionid = referralCodeCounter.promotionid;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public Builder counter(Integer num) {
            this.counter = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public ReferralCodeCounter build() {
            return new ReferralCodeCounter(this);
        }
    }
}
