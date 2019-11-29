package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceHistoryResponse extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Long DEFAULT_AFTER_SLASHED_PRICE = 0L;
    public static final Long DEFAULT_BEFORE_SLASHED_PRICE = 0L;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final Long DEFAULT_COIN_REWARD = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    public static final Long DEFAULT_HISTORY_ID = 0L;
    public static final Boolean DEFAULT_IS_FIRST_SLASH = false;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_RECEIVER_PHONE = "";
    public static final Integer DEFAULT_RECEIVER_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long after_slashed_price;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long before_slashed_price;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long coin_reward;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long history_id;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean is_first_slash;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String receiver_phone;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer receiver_userid;

    public SlashPriceHistoryResponse(Long l, Long l2, Integer num, String str, Long l3, Long l4, Long l5, String str2, Integer num2, Integer num3, Boolean bool, String str3, f fVar) {
        this.history_id = l;
        this.activity_id = l2;
        this.receiver_userid = num;
        this.receiver_phone = str;
        this.before_slashed_price = l3;
        this.after_slashed_price = l4;
        this.coin_reward = l5;
        this.nickname = str2;
        this.ctime = num2;
        this.mtime = num3;
        this.is_first_slash = bool;
        this.client_ip = str3;
        this.hashed_fingerprint = fVar;
    }

    private SlashPriceHistoryResponse(Builder builder) {
        this(builder.history_id, builder.activity_id, builder.receiver_userid, builder.receiver_phone, builder.before_slashed_price, builder.after_slashed_price, builder.coin_reward, builder.nickname, builder.ctime, builder.mtime, builder.is_first_slash, builder.client_ip, builder.hashed_fingerprint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceHistoryResponse)) {
            return false;
        }
        SlashPriceHistoryResponse slashPriceHistoryResponse = (SlashPriceHistoryResponse) obj;
        if (!equals((Object) this.history_id, (Object) slashPriceHistoryResponse.history_id) || !equals((Object) this.activity_id, (Object) slashPriceHistoryResponse.activity_id) || !equals((Object) this.receiver_userid, (Object) slashPriceHistoryResponse.receiver_userid) || !equals((Object) this.receiver_phone, (Object) slashPriceHistoryResponse.receiver_phone) || !equals((Object) this.before_slashed_price, (Object) slashPriceHistoryResponse.before_slashed_price) || !equals((Object) this.after_slashed_price, (Object) slashPriceHistoryResponse.after_slashed_price) || !equals((Object) this.coin_reward, (Object) slashPriceHistoryResponse.coin_reward) || !equals((Object) this.nickname, (Object) slashPriceHistoryResponse.nickname) || !equals((Object) this.ctime, (Object) slashPriceHistoryResponse.ctime) || !equals((Object) this.mtime, (Object) slashPriceHistoryResponse.mtime) || !equals((Object) this.is_first_slash, (Object) slashPriceHistoryResponse.is_first_slash) || !equals((Object) this.client_ip, (Object) slashPriceHistoryResponse.client_ip) || !equals((Object) this.hashed_fingerprint, (Object) slashPriceHistoryResponse.hashed_fingerprint)) {
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
        String str2 = this.nickname;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.is_first_slash;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.client_ip;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.hashed_fingerprint;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceHistoryResponse> {
        public Long activity_id;
        public Long after_slashed_price;
        public Long before_slashed_price;
        public String client_ip;
        public Long coin_reward;
        public Integer ctime;
        public f hashed_fingerprint;
        public Long history_id;
        public Boolean is_first_slash;
        public Integer mtime;
        public String nickname;
        public String receiver_phone;
        public Integer receiver_userid;

        public Builder() {
        }

        public Builder(SlashPriceHistoryResponse slashPriceHistoryResponse) {
            super(slashPriceHistoryResponse);
            if (slashPriceHistoryResponse != null) {
                this.history_id = slashPriceHistoryResponse.history_id;
                this.activity_id = slashPriceHistoryResponse.activity_id;
                this.receiver_userid = slashPriceHistoryResponse.receiver_userid;
                this.receiver_phone = slashPriceHistoryResponse.receiver_phone;
                this.before_slashed_price = slashPriceHistoryResponse.before_slashed_price;
                this.after_slashed_price = slashPriceHistoryResponse.after_slashed_price;
                this.coin_reward = slashPriceHistoryResponse.coin_reward;
                this.nickname = slashPriceHistoryResponse.nickname;
                this.ctime = slashPriceHistoryResponse.ctime;
                this.mtime = slashPriceHistoryResponse.mtime;
                this.is_first_slash = slashPriceHistoryResponse.is_first_slash;
                this.client_ip = slashPriceHistoryResponse.client_ip;
                this.hashed_fingerprint = slashPriceHistoryResponse.hashed_fingerprint;
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

        public Builder nickname(String str) {
            this.nickname = str;
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

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public SlashPriceHistoryResponse build() {
            return new SlashPriceHistoryResponse(this);
        }
    }
}
