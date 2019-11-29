package com.shopee.protocol.action;

import com.shopee.protocol.shop.WalletTopup;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseWalletTopupAdd extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3)
    public final WalletTopup topup;

    public ResponseWalletTopupAdd(String str, Integer num, WalletTopup walletTopup, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.topup = walletTopup;
        this.debug_msg = str2;
    }

    private ResponseWalletTopupAdd(Builder builder) {
        this(builder.requestid, builder.errcode, builder.topup, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseWalletTopupAdd)) {
            return false;
        }
        ResponseWalletTopupAdd responseWalletTopupAdd = (ResponseWalletTopupAdd) obj;
        if (!equals((Object) this.requestid, (Object) responseWalletTopupAdd.requestid) || !equals((Object) this.errcode, (Object) responseWalletTopupAdd.errcode) || !equals((Object) this.topup, (Object) responseWalletTopupAdd.topup) || !equals((Object) this.debug_msg, (Object) responseWalletTopupAdd.debug_msg)) {
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
        WalletTopup walletTopup = this.topup;
        int hashCode3 = (hashCode2 + (walletTopup != null ? walletTopup.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseWalletTopupAdd> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public WalletTopup topup;

        public Builder() {
        }

        public Builder(ResponseWalletTopupAdd responseWalletTopupAdd) {
            super(responseWalletTopupAdd);
            if (responseWalletTopupAdd != null) {
                this.requestid = responseWalletTopupAdd.requestid;
                this.errcode = responseWalletTopupAdd.errcode;
                this.topup = responseWalletTopupAdd.topup;
                this.debug_msg = responseWalletTopupAdd.debug_msg;
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

        public Builder topup(WalletTopup walletTopup) {
            this.topup = walletTopup;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseWalletTopupAdd build() {
            return new ResponseWalletTopupAdd(this);
        }
    }
}
