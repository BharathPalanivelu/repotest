package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletTransactionCreate extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_TARGET_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long target_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public WalletTransactionCreate(String str, String str2, BackendParam backendParam, Integer num, Integer num2, Long l, Long l2) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.type = num;
        this.userid = num2;
        this.amount = l;
        this.target_id = l2;
    }

    private WalletTransactionCreate(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.type, builder.userid, builder.amount, builder.target_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTransactionCreate)) {
            return false;
        }
        WalletTransactionCreate walletTransactionCreate = (WalletTransactionCreate) obj;
        if (!equals((Object) this.requestid, (Object) walletTransactionCreate.requestid) || !equals((Object) this.token, (Object) walletTransactionCreate.token) || !equals((Object) this.bparam, (Object) walletTransactionCreate.bparam) || !equals((Object) this.type, (Object) walletTransactionCreate.type) || !equals((Object) this.userid, (Object) walletTransactionCreate.userid) || !equals((Object) this.amount, (Object) walletTransactionCreate.amount) || !equals((Object) this.target_id, (Object) walletTransactionCreate.target_id)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.amount;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.target_id;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTransactionCreate> {
        public Long amount;
        public BackendParam bparam;
        public String requestid;
        public Long target_id;
        public String token;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(WalletTransactionCreate walletTransactionCreate) {
            super(walletTransactionCreate);
            if (walletTransactionCreate != null) {
                this.requestid = walletTransactionCreate.requestid;
                this.token = walletTransactionCreate.token;
                this.bparam = walletTransactionCreate.bparam;
                this.type = walletTransactionCreate.type;
                this.userid = walletTransactionCreate.userid;
                this.amount = walletTransactionCreate.amount;
                this.target_id = walletTransactionCreate.target_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder target_id(Long l) {
            this.target_id = l;
            return this;
        }

        public WalletTransactionCreate build() {
            return new WalletTransactionCreate(this);
        }
    }
}
