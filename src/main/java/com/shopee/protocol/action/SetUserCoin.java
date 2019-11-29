package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetUserCoin extends Message {
    public static final Long DEFAULT_COIN_AMOUNT = 0L;
    public static final String DEFAULT_ICON = "";
    public static final Boolean DEFAULT_NEED_CHECK_DUPLICATE_TXN = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_TRANS_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_amount;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_check_duplicate_txn;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer trans_type;

    public SetUserCoin(String str, BackendParam backendParam, Long l, Integer num, String str2, String str3, Long l2, Boolean bool) {
        this.requestid = str;
        this.bparam = backendParam;
        this.coin_amount = l;
        this.trans_type = num;
        this.title = str2;
        this.icon = str3;
        this.orderid = l2;
        this.need_check_duplicate_txn = bool;
    }

    private SetUserCoin(Builder builder) {
        this(builder.requestid, builder.bparam, builder.coin_amount, builder.trans_type, builder.title, builder.icon, builder.orderid, builder.need_check_duplicate_txn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetUserCoin)) {
            return false;
        }
        SetUserCoin setUserCoin = (SetUserCoin) obj;
        if (!equals((Object) this.requestid, (Object) setUserCoin.requestid) || !equals((Object) this.bparam, (Object) setUserCoin.bparam) || !equals((Object) this.coin_amount, (Object) setUserCoin.coin_amount) || !equals((Object) this.trans_type, (Object) setUserCoin.trans_type) || !equals((Object) this.title, (Object) setUserCoin.title) || !equals((Object) this.icon, (Object) setUserCoin.icon) || !equals((Object) this.orderid, (Object) setUserCoin.orderid) || !equals((Object) this.need_check_duplicate_txn, (Object) setUserCoin.need_check_duplicate_txn)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.coin_amount;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.trans_type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.title;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.icon;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.need_check_duplicate_txn;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetUserCoin> {
        public BackendParam bparam;
        public Long coin_amount;
        public String icon;
        public Boolean need_check_duplicate_txn;
        public Long orderid;
        public String requestid;
        public String title;
        public Integer trans_type;

        public Builder() {
        }

        public Builder(SetUserCoin setUserCoin) {
            super(setUserCoin);
            if (setUserCoin != null) {
                this.requestid = setUserCoin.requestid;
                this.bparam = setUserCoin.bparam;
                this.coin_amount = setUserCoin.coin_amount;
                this.trans_type = setUserCoin.trans_type;
                this.title = setUserCoin.title;
                this.icon = setUserCoin.icon;
                this.orderid = setUserCoin.orderid;
                this.need_check_duplicate_txn = setUserCoin.need_check_duplicate_txn;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder coin_amount(Long l) {
            this.coin_amount = l;
            return this;
        }

        public Builder trans_type(Integer num) {
            this.trans_type = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder need_check_duplicate_txn(Boolean bool) {
            this.need_check_duplicate_txn = bool;
            return this;
        }

        public SetUserCoin build() {
            return new SetUserCoin(this);
        }
    }
}
