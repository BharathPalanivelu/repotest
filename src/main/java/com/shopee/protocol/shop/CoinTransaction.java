package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CoinTransaction extends Message {
    public static final Long DEFAULT_COIN_AMOUNT = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_INFO = f.f32736b;
    public static final Long DEFAULT_NEW_AMOUNT = 0L;
    public static final Long DEFAULT_OLD_AMOUNT = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long coin_amount;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f info;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long new_amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long old_amount;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public CoinTransaction(Long l, Integer num, Long l2, Long l3, Long l4, Long l5, Integer num2, Integer num3, f fVar) {
        this.id = l;
        this.userid = num;
        this.orderid = l2;
        this.coin_amount = l3;
        this.old_amount = l4;
        this.new_amount = l5;
        this.type = num2;
        this.ctime = num3;
        this.info = fVar;
    }

    private CoinTransaction(Builder builder) {
        this(builder.id, builder.userid, builder.orderid, builder.coin_amount, builder.old_amount, builder.new_amount, builder.type, builder.ctime, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinTransaction)) {
            return false;
        }
        CoinTransaction coinTransaction = (CoinTransaction) obj;
        if (!equals((Object) this.id, (Object) coinTransaction.id) || !equals((Object) this.userid, (Object) coinTransaction.userid) || !equals((Object) this.orderid, (Object) coinTransaction.orderid) || !equals((Object) this.coin_amount, (Object) coinTransaction.coin_amount) || !equals((Object) this.old_amount, (Object) coinTransaction.old_amount) || !equals((Object) this.new_amount, (Object) coinTransaction.new_amount) || !equals((Object) this.type, (Object) coinTransaction.type) || !equals((Object) this.ctime, (Object) coinTransaction.ctime) || !equals((Object) this.info, (Object) coinTransaction.info)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.coin_amount;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.old_amount;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.new_amount;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.info;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinTransaction> {
        public Long coin_amount;
        public Integer ctime;
        public Long id;
        public f info;
        public Long new_amount;
        public Long old_amount;
        public Long orderid;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(CoinTransaction coinTransaction) {
            super(coinTransaction);
            if (coinTransaction != null) {
                this.id = coinTransaction.id;
                this.userid = coinTransaction.userid;
                this.orderid = coinTransaction.orderid;
                this.coin_amount = coinTransaction.coin_amount;
                this.old_amount = coinTransaction.old_amount;
                this.new_amount = coinTransaction.new_amount;
                this.type = coinTransaction.type;
                this.ctime = coinTransaction.ctime;
                this.info = coinTransaction.info;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder coin_amount(Long l) {
            this.coin_amount = l;
            return this;
        }

        public Builder old_amount(Long l) {
            this.old_amount = l;
            return this;
        }

        public Builder new_amount(Long l) {
            this.new_amount = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder info(f fVar) {
            this.info = fVar;
            return this;
        }

        public CoinTransaction build() {
            return new CoinTransaction(this);
        }
    }
}
