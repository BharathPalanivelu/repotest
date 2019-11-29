package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetUserCoinV2 extends Message {
    public static final Long DEFAULT_COIN_AMOUNT = 0L;
    public static final String DEFAULT_ICON = "";
    public static final Boolean DEFAULT_NEED_ASYNC = false;
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
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean need_async;
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

    public SetUserCoinV2(String str, BackendParam backendParam, Long l, Integer num, String str2, String str3, Long l2, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.bparam = backendParam;
        this.coin_amount = l;
        this.trans_type = num;
        this.title = str2;
        this.icon = str3;
        this.orderid = l2;
        this.need_check_duplicate_txn = bool;
        this.need_async = bool2;
    }

    private SetUserCoinV2(Builder builder) {
        this(builder.requestid, builder.bparam, builder.coin_amount, builder.trans_type, builder.title, builder.icon, builder.orderid, builder.need_check_duplicate_txn, builder.need_async);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetUserCoinV2)) {
            return false;
        }
        SetUserCoinV2 setUserCoinV2 = (SetUserCoinV2) obj;
        if (!equals((Object) this.requestid, (Object) setUserCoinV2.requestid) || !equals((Object) this.bparam, (Object) setUserCoinV2.bparam) || !equals((Object) this.coin_amount, (Object) setUserCoinV2.coin_amount) || !equals((Object) this.trans_type, (Object) setUserCoinV2.trans_type) || !equals((Object) this.title, (Object) setUserCoinV2.title) || !equals((Object) this.icon, (Object) setUserCoinV2.icon) || !equals((Object) this.orderid, (Object) setUserCoinV2.orderid) || !equals((Object) this.need_check_duplicate_txn, (Object) setUserCoinV2.need_check_duplicate_txn) || !equals((Object) this.need_async, (Object) setUserCoinV2.need_async)) {
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
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_async;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetUserCoinV2> {
        public BackendParam bparam;
        public Long coin_amount;
        public String icon;
        public Boolean need_async;
        public Boolean need_check_duplicate_txn;
        public Long orderid;
        public String requestid;
        public String title;
        public Integer trans_type;

        public Builder() {
        }

        public Builder(SetUserCoinV2 setUserCoinV2) {
            super(setUserCoinV2);
            if (setUserCoinV2 != null) {
                this.requestid = setUserCoinV2.requestid;
                this.bparam = setUserCoinV2.bparam;
                this.coin_amount = setUserCoinV2.coin_amount;
                this.trans_type = setUserCoinV2.trans_type;
                this.title = setUserCoinV2.title;
                this.icon = setUserCoinV2.icon;
                this.orderid = setUserCoinV2.orderid;
                this.need_check_duplicate_txn = setUserCoinV2.need_check_duplicate_txn;
                this.need_async = setUserCoinV2.need_async;
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

        public Builder need_async(Boolean bool) {
            this.need_async = bool;
            return this;
        }

        public SetUserCoinV2 build() {
            return new SetUserCoinV2(this);
        }
    }
}
