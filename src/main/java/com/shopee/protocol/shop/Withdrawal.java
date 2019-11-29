package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Withdrawal extends Message {
    public static final Integer DEFAULT_BANKACCOUNT_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_ROOT_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TOTAL_AMOUNT = 0L;
    public static final Long DEFAULT_TRANS_FEE = 0L;
    public static final Long DEFAULT_TYPE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final Long DEFAULT_WITHDRAWAL_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer bankaccount_id;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long root_id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long total_amount;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long trans_fee;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long withdrawal_id;

    public Withdrawal(Long l, Integer num, Long l2, Long l3, Long l4, Integer num2, Long l5, Integer num3, Integer num4, Integer num5, String str, f fVar) {
        this.withdrawal_id = l;
        this.userid = num;
        this.root_id = l2;
        this.total_amount = l3;
        this.trans_fee = l4;
        this.bankaccount_id = num2;
        this.type = l5;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.country = str;
        this.extinfo = fVar;
    }

    private Withdrawal(Builder builder) {
        this(builder.withdrawal_id, builder.userid, builder.root_id, builder.total_amount, builder.trans_fee, builder.bankaccount_id, builder.type, builder.status, builder.ctime, builder.mtime, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Withdrawal)) {
            return false;
        }
        Withdrawal withdrawal = (Withdrawal) obj;
        if (!equals((Object) this.withdrawal_id, (Object) withdrawal.withdrawal_id) || !equals((Object) this.userid, (Object) withdrawal.userid) || !equals((Object) this.root_id, (Object) withdrawal.root_id) || !equals((Object) this.total_amount, (Object) withdrawal.total_amount) || !equals((Object) this.trans_fee, (Object) withdrawal.trans_fee) || !equals((Object) this.bankaccount_id, (Object) withdrawal.bankaccount_id) || !equals((Object) this.type, (Object) withdrawal.type) || !equals((Object) this.status, (Object) withdrawal.status) || !equals((Object) this.ctime, (Object) withdrawal.ctime) || !equals((Object) this.mtime, (Object) withdrawal.mtime) || !equals((Object) this.country, (Object) withdrawal.country) || !equals((Object) this.extinfo, (Object) withdrawal.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.withdrawal_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.root_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.total_amount;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.trans_fee;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.bankaccount_id;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l5 = this.type;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Withdrawal> {
        public Integer bankaccount_id;
        public String country;
        public Integer ctime;
        public f extinfo;
        public Integer mtime;
        public Long root_id;
        public Integer status;
        public Long total_amount;
        public Long trans_fee;
        public Long type;
        public Integer userid;
        public Long withdrawal_id;

        public Builder() {
        }

        public Builder(Withdrawal withdrawal) {
            super(withdrawal);
            if (withdrawal != null) {
                this.withdrawal_id = withdrawal.withdrawal_id;
                this.userid = withdrawal.userid;
                this.root_id = withdrawal.root_id;
                this.total_amount = withdrawal.total_amount;
                this.trans_fee = withdrawal.trans_fee;
                this.bankaccount_id = withdrawal.bankaccount_id;
                this.type = withdrawal.type;
                this.status = withdrawal.status;
                this.ctime = withdrawal.ctime;
                this.mtime = withdrawal.mtime;
                this.country = withdrawal.country;
                this.extinfo = withdrawal.extinfo;
            }
        }

        public Builder withdrawal_id(Long l) {
            this.withdrawal_id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder root_id(Long l) {
            this.root_id = l;
            return this;
        }

        public Builder total_amount(Long l) {
            this.total_amount = l;
            return this;
        }

        public Builder trans_fee(Long l) {
            this.trans_fee = l;
            return this;
        }

        public Builder bankaccount_id(Integer num) {
            this.bankaccount_id = num;
            return this;
        }

        public Builder type(Long l) {
            this.type = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Withdrawal build() {
            return new Withdrawal(this);
        }
    }
}
