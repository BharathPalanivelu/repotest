package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseWalletTransactionCreate extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long transaction_id;

    public ResponseWalletTransactionCreate(String str, Integer num, String str2, Long l) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.transaction_id = l;
    }

    private ResponseWalletTransactionCreate(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.transaction_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseWalletTransactionCreate)) {
            return false;
        }
        ResponseWalletTransactionCreate responseWalletTransactionCreate = (ResponseWalletTransactionCreate) obj;
        if (!equals((Object) this.requestid, (Object) responseWalletTransactionCreate.requestid) || !equals((Object) this.errcode, (Object) responseWalletTransactionCreate.errcode) || !equals((Object) this.debug_msg, (Object) responseWalletTransactionCreate.debug_msg) || !equals((Object) this.transaction_id, (Object) responseWalletTransactionCreate.transaction_id)) {
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
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.transaction_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseWalletTransactionCreate> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public Long transaction_id;

        public Builder() {
        }

        public Builder(ResponseWalletTransactionCreate responseWalletTransactionCreate) {
            super(responseWalletTransactionCreate);
            if (responseWalletTransactionCreate != null) {
                this.requestid = responseWalletTransactionCreate.requestid;
                this.errcode = responseWalletTransactionCreate.errcode;
                this.debug_msg = responseWalletTransactionCreate.debug_msg;
                this.transaction_id = responseWalletTransactionCreate.transaction_id;
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public ResponseWalletTransactionCreate build() {
            return new ResponseWalletTransactionCreate(this);
        }
    }
}
