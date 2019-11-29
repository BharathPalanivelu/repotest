package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceHistory extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Long DEFAULT_AFTER_SLASHED_PRICE = 0L;
    public static final Long DEFAULT_BEFORE_SLASHED_PRICE = 0L;
    public static final Long DEFAULT_COIN_REWARD = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_HISTORY_ID = 0L;
    public static final Boolean DEFAULT_IS_FIRST_SLASH = false;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_RECEIVER_PHONE = "";
    public static final Integer DEFAULT_RECEIVER_USERID = 0;
    public static final Integer DEFAULT_SENDER_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long after_slashed_price;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long before_slashed_price;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long coin_reward;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long history_id;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean is_first_slash;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String receiver_phone;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer receiver_userid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer sender_userid;

    public SlashPriceHistory(Long l, Long l2, Integer num, String str, Long l3, Long l4, Long l5, Integer num2, Integer num3, Boolean bool, f fVar, Integer num4) {
        this.history_id = l;
        this.activity_id = l2;
        this.receiver_userid = num;
        this.receiver_phone = str;
        this.before_slashed_price = l3;
        this.after_slashed_price = l4;
        this.coin_reward = l5;
        this.ctime = num2;
        this.mtime = num3;
        this.is_first_slash = bool;
        this.extinfo = fVar;
        this.sender_userid = num4;
    }

    private SlashPriceHistory(Builder builder) {
        this(builder.history_id, builder.activity_id, builder.receiver_userid, builder.receiver_phone, builder.before_slashed_price, builder.after_slashed_price, builder.coin_reward, builder.ctime, builder.mtime, builder.is_first_slash, builder.extinfo, builder.sender_userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceHistory)) {
            return false;
        }
        SlashPriceHistory slashPriceHistory = (SlashPriceHistory) obj;
        if (!equals((Object) this.history_id, (Object) slashPriceHistory.history_id) || !equals((Object) this.activity_id, (Object) slashPriceHistory.activity_id) || !equals((Object) this.receiver_userid, (Object) slashPriceHistory.receiver_userid) || !equals((Object) this.receiver_phone, (Object) slashPriceHistory.receiver_phone) || !equals((Object) this.before_slashed_price, (Object) slashPriceHistory.before_slashed_price) || !equals((Object) this.after_slashed_price, (Object) slashPriceHistory.after_slashed_price) || !equals((Object) this.coin_reward, (Object) slashPriceHistory.coin_reward) || !equals((Object) this.ctime, (Object) slashPriceHistory.ctime) || !equals((Object) this.mtime, (Object) slashPriceHistory.mtime) || !equals((Object) this.is_first_slash, (Object) slashPriceHistory.is_first_slash) || !equals((Object) this.extinfo, (Object) slashPriceHistory.extinfo) || !equals((Object) this.sender_userid, (Object) slashPriceHistory.sender_userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.history_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.activity_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.receiver_userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.receiver_phone;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.before_slashed_price;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.after_slashed_price;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.coin_reward;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.is_first_slash;
        int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num4 = this.sender_userid;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceHistory> {
        public Long activity_id;
        public Long after_slashed_price;
        public Long before_slashed_price;
        public Long coin_reward;
        public Integer ctime;
        public f extinfo;
        public Long history_id;
        public Boolean is_first_slash;
        public Integer mtime;
        public String receiver_phone;
        public Integer receiver_userid;
        public Integer sender_userid;

        public Builder() {
        }

        public Builder(SlashPriceHistory slashPriceHistory) {
            super(slashPriceHistory);
            if (slashPriceHistory != null) {
                this.history_id = slashPriceHistory.history_id;
                this.activity_id = slashPriceHistory.activity_id;
                this.receiver_userid = slashPriceHistory.receiver_userid;
                this.receiver_phone = slashPriceHistory.receiver_phone;
                this.before_slashed_price = slashPriceHistory.before_slashed_price;
                this.after_slashed_price = slashPriceHistory.after_slashed_price;
                this.coin_reward = slashPriceHistory.coin_reward;
                this.ctime = slashPriceHistory.ctime;
                this.mtime = slashPriceHistory.mtime;
                this.is_first_slash = slashPriceHistory.is_first_slash;
                this.extinfo = slashPriceHistory.extinfo;
                this.sender_userid = slashPriceHistory.sender_userid;
            }
        }

        public Builder history_id(Long l) {
            this.history_id = l;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder receiver_userid(Integer num) {
            this.receiver_userid = num;
            return this;
        }

        public Builder receiver_phone(String str) {
            this.receiver_phone = str;
            return this;
        }

        public Builder before_slashed_price(Long l) {
            this.before_slashed_price = l;
            return this;
        }

        public Builder after_slashed_price(Long l) {
            this.after_slashed_price = l;
            return this;
        }

        public Builder coin_reward(Long l) {
            this.coin_reward = l;
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

        public Builder is_first_slash(Boolean bool) {
            this.is_first_slash = bool;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder sender_userid(Integer num) {
            this.sender_userid = num;
            return this;
        }

        public SlashPriceHistory build() {
            return new SlashPriceHistory(this);
        }
    }
}
