package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WalletTransaction extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_NEW_AVAILABLE = 0L;
    public static final Long DEFAULT_NEW_OUTGOING = 0L;
    public static final Long DEFAULT_OLD_AVAILABLE = 0L;
    public static final Long DEFAULT_OLD_OUTGOING = 0L;
    public static final Long DEFAULT_TARGET_ID = 0L;
    public static final Long DEFAULT_TRACE_ID = 0L;
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long new_available;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long new_outgoing;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long old_available;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long old_outgoing;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long target_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long trace_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public WalletTransaction(Long l, Long l2, Integer num, Long l3, Long l4, Long l5, Long l6, Long l7, Integer num2, Integer num3, f fVar) {
        this.transaction_id = l;
        this.trace_id = l2;
        this.userid = num;
        this.target_id = l3;
        this.old_available = l4;
        this.new_available = l5;
        this.old_outgoing = l6;
        this.new_outgoing = l7;
        this.type = num2;
        this.ctime = num3;
        this.extinfo = fVar;
    }

    private WalletTransaction(Builder builder) {
        this(builder.transaction_id, builder.trace_id, builder.userid, builder.target_id, builder.old_available, builder.new_available, builder.old_outgoing, builder.new_outgoing, builder.type, builder.ctime, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTransaction)) {
            return false;
        }
        WalletTransaction walletTransaction = (WalletTransaction) obj;
        if (!equals((Object) this.transaction_id, (Object) walletTransaction.transaction_id) || !equals((Object) this.trace_id, (Object) walletTransaction.trace_id) || !equals((Object) this.userid, (Object) walletTransaction.userid) || !equals((Object) this.target_id, (Object) walletTransaction.target_id) || !equals((Object) this.old_available, (Object) walletTransaction.old_available) || !equals((Object) this.new_available, (Object) walletTransaction.new_available) || !equals((Object) this.old_outgoing, (Object) walletTransaction.old_outgoing) || !equals((Object) this.new_outgoing, (Object) walletTransaction.new_outgoing) || !equals((Object) this.type, (Object) walletTransaction.type) || !equals((Object) this.ctime, (Object) walletTransaction.ctime) || !equals((Object) this.extinfo, (Object) walletTransaction.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.transaction_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.trace_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.target_id;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.old_available;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.new_available;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.old_outgoing;
        int hashCode7 = (hashCode6 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.new_outgoing;
        int hashCode8 = (hashCode7 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTransaction> {
        public Integer ctime;
        public f extinfo;
        public Long new_available;
        public Long new_outgoing;
        public Long old_available;
        public Long old_outgoing;
        public Long target_id;
        public Long trace_id;
        public Long transaction_id;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(WalletTransaction walletTransaction) {
            super(walletTransaction);
            if (walletTransaction != null) {
                this.transaction_id = walletTransaction.transaction_id;
                this.trace_id = walletTransaction.trace_id;
                this.userid = walletTransaction.userid;
                this.target_id = walletTransaction.target_id;
                this.old_available = walletTransaction.old_available;
                this.new_available = walletTransaction.new_available;
                this.old_outgoing = walletTransaction.old_outgoing;
                this.new_outgoing = walletTransaction.new_outgoing;
                this.type = walletTransaction.type;
                this.ctime = walletTransaction.ctime;
                this.extinfo = walletTransaction.extinfo;
            }
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public Builder trace_id(Long l) {
            this.trace_id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder target_id(Long l) {
            this.target_id = l;
            return this;
        }

        public Builder old_available(Long l) {
            this.old_available = l;
            return this;
        }

        public Builder new_available(Long l) {
            this.new_available = l;
            return this;
        }

        public Builder old_outgoing(Long l) {
            this.old_outgoing = l;
            return this;
        }

        public Builder new_outgoing(Long l) {
            this.new_outgoing = l;
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

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public WalletTransaction build() {
            return new WalletTransaction(this);
        }
    }
}
