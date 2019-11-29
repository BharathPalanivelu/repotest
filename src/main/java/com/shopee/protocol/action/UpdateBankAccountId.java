package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UpdateBankAccountId extends Message {
    public static final Integer DEFAULT_BANKACCOUNT_ID = 0;
    public static final Long DEFAULT_BANK_TRANSFER_TIME = 0L;
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long bank_transfer_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer bankaccount_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long order_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public UpdateBankAccountId(String str, Integer num, Long l, Long l2, Integer num2, Long l3, String str2, Long l4) {
        this.requestid = str;
        this.userid = num;
        this.order_id = l;
        this.refund_id = l2;
        this.bankaccount_id = num2;
        this.return_id = l3;
        this.token = str2;
        this.bank_transfer_time = l4;
    }

    private UpdateBankAccountId(Builder builder) {
        this(builder.requestid, builder.userid, builder.order_id, builder.refund_id, builder.bankaccount_id, builder.return_id, builder.token, builder.bank_transfer_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateBankAccountId)) {
            return false;
        }
        UpdateBankAccountId updateBankAccountId = (UpdateBankAccountId) obj;
        if (!equals((Object) this.requestid, (Object) updateBankAccountId.requestid) || !equals((Object) this.userid, (Object) updateBankAccountId.userid) || !equals((Object) this.order_id, (Object) updateBankAccountId.order_id) || !equals((Object) this.refund_id, (Object) updateBankAccountId.refund_id) || !equals((Object) this.bankaccount_id, (Object) updateBankAccountId.bankaccount_id) || !equals((Object) this.return_id, (Object) updateBankAccountId.return_id) || !equals((Object) this.token, (Object) updateBankAccountId.token) || !equals((Object) this.bank_transfer_time, (Object) updateBankAccountId.bank_transfer_time)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.order_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.refund_id;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.bankaccount_id;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.return_id;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l4 = this.bank_transfer_time;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateBankAccountId> {
        public Long bank_transfer_time;
        public Integer bankaccount_id;
        public Long order_id;
        public Long refund_id;
        public String requestid;
        public Long return_id;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(UpdateBankAccountId updateBankAccountId) {
            super(updateBankAccountId);
            if (updateBankAccountId != null) {
                this.requestid = updateBankAccountId.requestid;
                this.userid = updateBankAccountId.userid;
                this.order_id = updateBankAccountId.order_id;
                this.refund_id = updateBankAccountId.refund_id;
                this.bankaccount_id = updateBankAccountId.bankaccount_id;
                this.return_id = updateBankAccountId.return_id;
                this.token = updateBankAccountId.token;
                this.bank_transfer_time = updateBankAccountId.bank_transfer_time;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder bankaccount_id(Integer num) {
            this.bankaccount_id = num;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bank_transfer_time(Long l) {
            this.bank_transfer_time = l;
            return this;
        }

        public UpdateBankAccountId build() {
            checkRequiredFields();
            return new UpdateBankAccountId(this);
        }
    }
}
