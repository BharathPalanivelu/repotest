package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopBalance;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseShopBalance extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_LASTMONTH_INCOME = 0L;
    public static final Long DEFAULT_LASTWEEK_INCOME = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final ShopBalance balance;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long lastmonth_income;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long lastweek_income;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseShopBalance(String str, Integer num, ShopBalance shopBalance, Long l, Long l2) {
        this.requestid = str;
        this.errcode = num;
        this.balance = shopBalance;
        this.lastmonth_income = l;
        this.lastweek_income = l2;
    }

    private ResponseShopBalance(Builder builder) {
        this(builder.requestid, builder.errcode, builder.balance, builder.lastmonth_income, builder.lastweek_income);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopBalance)) {
            return false;
        }
        ResponseShopBalance responseShopBalance = (ResponseShopBalance) obj;
        if (!equals((Object) this.requestid, (Object) responseShopBalance.requestid) || !equals((Object) this.errcode, (Object) responseShopBalance.errcode) || !equals((Object) this.balance, (Object) responseShopBalance.balance) || !equals((Object) this.lastmonth_income, (Object) responseShopBalance.lastmonth_income) || !equals((Object) this.lastweek_income, (Object) responseShopBalance.lastweek_income)) {
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
        ShopBalance shopBalance = this.balance;
        int hashCode3 = (hashCode2 + (shopBalance != null ? shopBalance.hashCode() : 0)) * 37;
        Long l = this.lastmonth_income;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.lastweek_income;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseShopBalance> {
        public ShopBalance balance;
        public Integer errcode;
        public Long lastmonth_income;
        public Long lastweek_income;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseShopBalance responseShopBalance) {
            super(responseShopBalance);
            if (responseShopBalance != null) {
                this.requestid = responseShopBalance.requestid;
                this.errcode = responseShopBalance.errcode;
                this.balance = responseShopBalance.balance;
                this.lastmonth_income = responseShopBalance.lastmonth_income;
                this.lastweek_income = responseShopBalance.lastweek_income;
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

        public Builder balance(ShopBalance shopBalance) {
            this.balance = shopBalance;
            return this;
        }

        public Builder lastmonth_income(Long l) {
            this.lastmonth_income = l;
            return this;
        }

        public Builder lastweek_income(Long l) {
            this.lastweek_income = l;
            return this;
        }

        public ResponseShopBalance build() {
            checkRequiredFields();
            return new ResponseShopBalance(this);
        }
    }
}
