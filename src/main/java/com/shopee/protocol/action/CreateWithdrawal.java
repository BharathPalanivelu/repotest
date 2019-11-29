package com.shopee.protocol.action;

import com.shopee.protocol.shop.Withdrawal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CreateWithdrawal extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_REQUEST_USERID = 0;
    public static final List<Withdrawal> DEFAULT_SUB_WITHDRAWAL_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 4)
    public final Withdrawal main_withdrawal;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer request_userid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Withdrawal.class, tag = 5)
    public final List<Withdrawal> sub_withdrawal_list;

    public CreateWithdrawal(String str, BackendParam backendParam, Integer num, Withdrawal withdrawal, List<Withdrawal> list) {
        this.requestid = str;
        this.bparam = backendParam;
        this.request_userid = num;
        this.main_withdrawal = withdrawal;
        this.sub_withdrawal_list = immutableCopyOf(list);
    }

    private CreateWithdrawal(Builder builder) {
        this(builder.requestid, builder.bparam, builder.request_userid, builder.main_withdrawal, builder.sub_withdrawal_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateWithdrawal)) {
            return false;
        }
        CreateWithdrawal createWithdrawal = (CreateWithdrawal) obj;
        if (!equals((Object) this.requestid, (Object) createWithdrawal.requestid) || !equals((Object) this.bparam, (Object) createWithdrawal.bparam) || !equals((Object) this.request_userid, (Object) createWithdrawal.request_userid) || !equals((Object) this.main_withdrawal, (Object) createWithdrawal.main_withdrawal) || !equals((List<?>) this.sub_withdrawal_list, (List<?>) createWithdrawal.sub_withdrawal_list)) {
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
        Withdrawal withdrawal = this.main_withdrawal;
        if (withdrawal != null) {
            i2 = withdrawal.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<Withdrawal> list = this.sub_withdrawal_list;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<CreateWithdrawal> {
        public BackendParam bparam;
        public Withdrawal main_withdrawal;
        public Integer request_userid;
        public String requestid;
        public List<Withdrawal> sub_withdrawal_list;

        public Builder() {
        }

        public Builder(CreateWithdrawal createWithdrawal) {
            super(createWithdrawal);
            if (createWithdrawal != null) {
                this.requestid = createWithdrawal.requestid;
                this.bparam = createWithdrawal.bparam;
                this.request_userid = createWithdrawal.request_userid;
                this.main_withdrawal = createWithdrawal.main_withdrawal;
                this.sub_withdrawal_list = CreateWithdrawal.copyOf(createWithdrawal.sub_withdrawal_list);
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

        public Builder main_withdrawal(Withdrawal withdrawal) {
            this.main_withdrawal = withdrawal;
            return this;
        }

        public Builder sub_withdrawal_list(List<Withdrawal> list) {
            this.sub_withdrawal_list = checkForNulls(list);
            return this;
        }

        public CreateWithdrawal build() {
            return new CreateWithdrawal(this);
        }
    }
}
