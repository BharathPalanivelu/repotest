package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSlashPrice extends Message {
    public static final Long DEFAULT_COIN_REWARD = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_IS_FIRST_TIME_SLASHER = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_SLASHED_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long coin_reward;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_first_time_slasher;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long slashed_value;

    public ResponseSlashPrice(String str, Integer num, Long l, Long l2, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.slashed_value = l;
        this.coin_reward = l2;
        this.is_first_time_slasher = bool;
    }

    private ResponseSlashPrice(Builder builder) {
        this(builder.requestid, builder.errcode, builder.slashed_value, builder.coin_reward, builder.is_first_time_slasher);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSlashPrice)) {
            return false;
        }
        ResponseSlashPrice responseSlashPrice = (ResponseSlashPrice) obj;
        if (!equals((Object) this.requestid, (Object) responseSlashPrice.requestid) || !equals((Object) this.errcode, (Object) responseSlashPrice.errcode) || !equals((Object) this.slashed_value, (Object) responseSlashPrice.slashed_value) || !equals((Object) this.coin_reward, (Object) responseSlashPrice.coin_reward) || !equals((Object) this.is_first_time_slasher, (Object) responseSlashPrice.is_first_time_slasher)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.slashed_value;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.coin_reward;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.is_first_time_slasher;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSlashPrice> {
        public Long coin_reward;
        public Integer errcode;
        public Boolean is_first_time_slasher;
        public String requestid;
        public Long slashed_value;

        public Builder() {
        }

        public Builder(ResponseSlashPrice responseSlashPrice) {
            super(responseSlashPrice);
            if (responseSlashPrice != null) {
                this.requestid = responseSlashPrice.requestid;
                this.errcode = responseSlashPrice.errcode;
                this.slashed_value = responseSlashPrice.slashed_value;
                this.coin_reward = responseSlashPrice.coin_reward;
                this.is_first_time_slasher = responseSlashPrice.is_first_time_slasher;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder slashed_value(Long l) {
            this.slashed_value = l;
            return this;
        }

        public Builder coin_reward(Long l) {
            this.coin_reward = l;
            return this;
        }

        public Builder is_first_time_slasher(Boolean bool) {
            this.is_first_time_slasher = bool;
            return this;
        }

        public ResponseSlashPrice build() {
            return new ResponseSlashPrice(this);
        }
    }
}
