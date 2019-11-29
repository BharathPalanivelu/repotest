package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceCoin extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Long DEFAULT_COIN_REWARD = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long coin_reward;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceCoin(Integer num, Long l, String str, Long l2, Integer num2, Integer num3, Integer num4) {
        this.id = num;
        this.activity_id = l;
        this.phone = str;
        this.coin_reward = l2;
        this.status = num2;
        this.ctime = num3;
        this.mtime = num4;
    }

    private SlashPriceCoin(Builder builder) {
        this(builder.id, builder.activity_id, builder.phone, builder.coin_reward, builder.status, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceCoin)) {
            return false;
        }
        SlashPriceCoin slashPriceCoin = (SlashPriceCoin) obj;
        if (!equals((Object) this.id, (Object) slashPriceCoin.id) || !equals((Object) this.activity_id, (Object) slashPriceCoin.activity_id) || !equals((Object) this.phone, (Object) slashPriceCoin.phone) || !equals((Object) this.coin_reward, (Object) slashPriceCoin.coin_reward) || !equals((Object) this.status, (Object) slashPriceCoin.status) || !equals((Object) this.ctime, (Object) slashPriceCoin.ctime) || !equals((Object) this.mtime, (Object) slashPriceCoin.mtime)) {
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
        Long l = this.activity_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.phone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.coin_reward;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceCoin> {
        public Long activity_id;
        public Long coin_reward;
        public Integer ctime;
        public Integer id;
        public Integer mtime;
        public String phone;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceCoin slashPriceCoin) {
            super(slashPriceCoin);
            if (slashPriceCoin != null) {
                this.id = slashPriceCoin.id;
                this.activity_id = slashPriceCoin.activity_id;
                this.phone = slashPriceCoin.phone;
                this.coin_reward = slashPriceCoin.coin_reward;
                this.status = slashPriceCoin.status;
                this.ctime = slashPriceCoin.ctime;
                this.mtime = slashPriceCoin.mtime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder coin_reward(Long l) {
            this.coin_reward = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public SlashPriceCoin build() {
            return new SlashPriceCoin(this);
        }
    }
}
