package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MarketPushSendingInfo extends Message {
    public static final Integer DEFAULT_AUTO_TYPE = 0;
    public static final Boolean DEFAULT_IGNORE_CB = false;
    public static final Integer DEFAULT_MAX_USER_CTIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer auto_type;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean ignore_cb;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer max_user_ctime;

    public MarketPushSendingInfo(Integer num, Integer num2, Boolean bool) {
        this.auto_type = num;
        this.max_user_ctime = num2;
        this.ignore_cb = bool;
    }

    private MarketPushSendingInfo(Builder builder) {
        this(builder.auto_type, builder.max_user_ctime, builder.ignore_cb);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPushSendingInfo)) {
            return false;
        }
        MarketPushSendingInfo marketPushSendingInfo = (MarketPushSendingInfo) obj;
        if (!equals((Object) this.auto_type, (Object) marketPushSendingInfo.auto_type) || !equals((Object) this.max_user_ctime, (Object) marketPushSendingInfo.max_user_ctime) || !equals((Object) this.ignore_cb, (Object) marketPushSendingInfo.ignore_cb)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.auto_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.max_user_ctime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.ignore_cb;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPushSendingInfo> {
        public Integer auto_type;
        public Boolean ignore_cb;
        public Integer max_user_ctime;

        public Builder() {
        }

        public Builder(MarketPushSendingInfo marketPushSendingInfo) {
            super(marketPushSendingInfo);
            if (marketPushSendingInfo != null) {
                this.auto_type = marketPushSendingInfo.auto_type;
                this.max_user_ctime = marketPushSendingInfo.max_user_ctime;
                this.ignore_cb = marketPushSendingInfo.ignore_cb;
            }
        }

        public Builder auto_type(Integer num) {
            this.auto_type = num;
            return this;
        }

        public Builder max_user_ctime(Integer num) {
            this.max_user_ctime = num;
            return this;
        }

        public Builder ignore_cb(Boolean bool) {
            this.ignore_cb = bool;
            return this;
        }

        public MarketPushSendingInfo build() {
            return new MarketPushSendingInfo(this);
        }
    }
}
