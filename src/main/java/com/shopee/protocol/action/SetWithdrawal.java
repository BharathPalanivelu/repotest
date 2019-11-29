package com.shopee.protocol.action;

import com.shopee.protocol.shop.Withdrawal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetWithdrawal extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_REQUEST_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer request_userid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4)
    public final Withdrawal withdrawal;

    public SetWithdrawal(String str, BackendParam backendParam, Integer num, Withdrawal withdrawal2) {
        this.requestid = str;
        this.bparam = backendParam;
        this.request_userid = num;
        this.withdrawal = withdrawal2;
    }

    private SetWithdrawal(Builder builder) {
        this(builder.requestid, builder.bparam, builder.request_userid, builder.withdrawal);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetWithdrawal)) {
            return false;
        }
        SetWithdrawal setWithdrawal = (SetWithdrawal) obj;
        if (!equals((Object) this.requestid, (Object) setWithdrawal.requestid) || !equals((Object) this.bparam, (Object) setWithdrawal.bparam) || !equals((Object) this.request_userid, (Object) setWithdrawal.request_userid) || !equals((Object) this.withdrawal, (Object) setWithdrawal.withdrawal)) {
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
        Integer num = this.request_userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Withdrawal withdrawal2 = this.withdrawal;
        if (withdrawal2 != null) {
            i2 = withdrawal2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetWithdrawal> {
        public BackendParam bparam;
        public Integer request_userid;
        public String requestid;
        public Withdrawal withdrawal;

        public Builder() {
        }

        public Builder(SetWithdrawal setWithdrawal) {
            super(setWithdrawal);
            if (setWithdrawal != null) {
                this.requestid = setWithdrawal.requestid;
                this.bparam = setWithdrawal.bparam;
                this.request_userid = setWithdrawal.request_userid;
                this.withdrawal = setWithdrawal.withdrawal;
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

        public Builder request_userid(Integer num) {
            this.request_userid = num;
            return this;
        }

        public Builder withdrawal(Withdrawal withdrawal2) {
            this.withdrawal = withdrawal2;
            return this;
        }

        public SetWithdrawal build() {
            return new SetWithdrawal(this);
        }
    }
}
