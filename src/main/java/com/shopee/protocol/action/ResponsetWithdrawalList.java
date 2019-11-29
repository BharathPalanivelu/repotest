package com.shopee.protocol.action;

import com.shopee.protocol.shop.Withdrawal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsetWithdrawalList extends Message {
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

    public ResponsetWithdrawalList(String str, Integer num, List<Withdrawal> list) {
        this.requestid = str;
        this.errcode = num;
        this.withdrawal_list = immutableCopyOf(list);
    }

    private ResponsetWithdrawalList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.withdrawal_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsetWithdrawalList)) {
            return false;
        }
        ResponsetWithdrawalList responsetWithdrawalList = (ResponsetWithdrawalList) obj;
        if (!equals((Object) this.requestid, (Object) responsetWithdrawalList.requestid) || !equals((Object) this.errcode, (Object) responsetWithdrawalList.errcode) || !equals((List<?>) this.withdrawal_list, (List<?>) responsetWithdrawalList.withdrawal_list)) {
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

    public static final class Builder extends Message.Builder<ResponsetWithdrawalList> {
        public Integer errcode;
        public String requestid;
        public List<Withdrawal> withdrawal_list;

        public Builder() {
        }

        public Builder(ResponsetWithdrawalList responsetWithdrawalList) {
            super(responsetWithdrawalList);
            if (responsetWithdrawalList != null) {
                this.requestid = responsetWithdrawalList.requestid;
                this.errcode = responsetWithdrawalList.errcode;
                this.withdrawal_list = ResponsetWithdrawalList.copyOf(responsetWithdrawalList.withdrawal_list);
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

        public ResponsetWithdrawalList build() {
            return new ResponsetWithdrawalList(this);
        }
    }
}
