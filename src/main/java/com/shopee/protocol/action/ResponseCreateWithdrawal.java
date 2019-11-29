package com.shopee.protocol.action;

import com.shopee.protocol.shop.Withdrawal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCreateWithdrawal extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Withdrawal> DEFAULT_WITHDRAWAL_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Withdrawal.class, tag = 3)
    public final List<Withdrawal> withdrawal_list;

    public ResponseCreateWithdrawal(String str, Integer num, List<Withdrawal> list) {
        this.requestid = str;
        this.errcode = num;
        this.withdrawal_list = immutableCopyOf(list);
    }

    private ResponseCreateWithdrawal(Builder builder) {
        this(builder.requestid, builder.errcode, builder.withdrawal_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCreateWithdrawal)) {
            return false;
        }
        ResponseCreateWithdrawal responseCreateWithdrawal = (ResponseCreateWithdrawal) obj;
        if (!equals((Object) this.requestid, (Object) responseCreateWithdrawal.requestid) || !equals((Object) this.errcode, (Object) responseCreateWithdrawal.errcode) || !equals((List<?>) this.withdrawal_list, (List<?>) responseCreateWithdrawal.withdrawal_list)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Withdrawal> list = this.withdrawal_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCreateWithdrawal> {
        public Integer errcode;
        public String requestid;
        public List<Withdrawal> withdrawal_list;

        public Builder() {
        }

        public Builder(ResponseCreateWithdrawal responseCreateWithdrawal) {
            super(responseCreateWithdrawal);
            if (responseCreateWithdrawal != null) {
                this.requestid = responseCreateWithdrawal.requestid;
                this.errcode = responseCreateWithdrawal.errcode;
                this.withdrawal_list = ResponseCreateWithdrawal.copyOf(responseCreateWithdrawal.withdrawal_list);
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

        public Builder withdrawal_list(List<Withdrawal> list) {
            this.withdrawal_list = checkForNulls(list);
            return this;
        }

        public ResponseCreateWithdrawal build() {
            return new ResponseCreateWithdrawal(this);
        }
    }
}
