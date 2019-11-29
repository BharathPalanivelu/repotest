package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopBalance extends Message {
    public static final Long DEFAULT_AVAILABLE = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final Long DEFAULT_FROZEN = 0L;
    public static final Integer DEFAULT_LAST_WITHDRAW_TIME = 0;
    public static final Long DEFAULT_OTHER = 0L;
    public static final Long DEFAULT_PROCESSING = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_TOTAL_WITHDRAWN = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final Long DEFAULT_WITHDRAW_LIMIT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long available;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long frozen;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer last_withdraw_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long other;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long processing;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long total_withdrawn;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long withdraw_limit;

    public ShopBalance(Integer num, Integer num2, String str, Long l, Long l2, Long l3, Integer num3, Long l4, Long l5, Long l6) {
        this.shopid = num;
        this.userid = num2;
        this.currency = str;
        this.available = l;
        this.frozen = l2;
        this.total_withdrawn = l3;
        this.last_withdraw_time = num3;
        this.processing = l4;
        this.other = l5;
        this.withdraw_limit = l6;
    }

    private ShopBalance(Builder builder) {
        this(builder.shopid, builder.userid, builder.currency, builder.available, builder.frozen, builder.total_withdrawn, builder.last_withdraw_time, builder.processing, builder.other, builder.withdraw_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopBalance)) {
            return false;
        }
        ShopBalance shopBalance = (ShopBalance) obj;
        if (!equals((Object) this.shopid, (Object) shopBalance.shopid) || !equals((Object) this.userid, (Object) shopBalance.userid) || !equals((Object) this.currency, (Object) shopBalance.currency) || !equals((Object) this.available, (Object) shopBalance.available) || !equals((Object) this.frozen, (Object) shopBalance.frozen) || !equals((Object) this.total_withdrawn, (Object) shopBalance.total_withdrawn) || !equals((Object) this.last_withdraw_time, (Object) shopBalance.last_withdraw_time) || !equals((Object) this.processing, (Object) shopBalance.processing) || !equals((Object) this.other, (Object) shopBalance.other) || !equals((Object) this.withdraw_limit, (Object) shopBalance.withdraw_limit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.available;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.frozen;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.total_withdrawn;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.last_withdraw_time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.processing;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.other;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.withdraw_limit;
        if (l6 != null) {
            i2 = l6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopBalance> {
        public Long available;
        public String currency;
        public Long frozen;
        public Integer last_withdraw_time;
        public Long other;
        public Long processing;
        public Integer shopid;
        public Long total_withdrawn;
        public Integer userid;
        public Long withdraw_limit;

        public Builder() {
        }

        public Builder(ShopBalance shopBalance) {
            super(shopBalance);
            if (shopBalance != null) {
                this.shopid = shopBalance.shopid;
                this.userid = shopBalance.userid;
                this.currency = shopBalance.currency;
                this.available = shopBalance.available;
                this.frozen = shopBalance.frozen;
                this.total_withdrawn = shopBalance.total_withdrawn;
                this.last_withdraw_time = shopBalance.last_withdraw_time;
                this.processing = shopBalance.processing;
                this.other = shopBalance.other;
                this.withdraw_limit = shopBalance.withdraw_limit;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder available(Long l) {
            this.available = l;
            return this;
        }

        public Builder frozen(Long l) {
            this.frozen = l;
            return this;
        }

        public Builder total_withdrawn(Long l) {
            this.total_withdrawn = l;
            return this;
        }

        public Builder last_withdraw_time(Integer num) {
            this.last_withdraw_time = num;
            return this;
        }

        public Builder processing(Long l) {
            this.processing = l;
            return this;
        }

        public Builder other(Long l) {
            this.other = l;
            return this;
        }

        public Builder withdraw_limit(Long l) {
            this.withdraw_limit = l;
            return this;
        }

        public ShopBalance build() {
            return new ShopBalance(this);
        }
    }
}
