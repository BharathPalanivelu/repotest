package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Referral;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseReferralList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Referral> DEFAULT_REFERRAL = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Account> DEFAULT_USER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = Referral.class, tag = 3)
    public final List<Referral> referral;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Account.class, tag = 4)
    public final List<Account> user;

    public ResponseReferralList(String str, Integer num, List<Referral> list, List<Account> list2) {
        this.requestid = str;
        this.errcode = num;
        this.referral = immutableCopyOf(list);
        this.user = immutableCopyOf(list2);
    }

    private ResponseReferralList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.referral, builder.user);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReferralList)) {
            return false;
        }
        ResponseReferralList responseReferralList = (ResponseReferralList) obj;
        if (!equals((Object) this.requestid, (Object) responseReferralList.requestid) || !equals((Object) this.errcode, (Object) responseReferralList.errcode) || !equals((List<?>) this.referral, (List<?>) responseReferralList.referral) || !equals((List<?>) this.user, (List<?>) responseReferralList.user)) {
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
        List<Referral> list = this.referral;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Account> list2 = this.user;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseReferralList> {
        public Integer errcode;
        public List<Referral> referral;
        public String requestid;
        public List<Account> user;

        public Builder() {
        }

        public Builder(ResponseReferralList responseReferralList) {
            super(responseReferralList);
            if (responseReferralList != null) {
                this.requestid = responseReferralList.requestid;
                this.errcode = responseReferralList.errcode;
                this.referral = ResponseReferralList.copyOf(responseReferralList.referral);
                this.user = ResponseReferralList.copyOf(responseReferralList.user);
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

        public Builder referral(List<Referral> list) {
            this.referral = checkForNulls(list);
            return this;
        }

        public Builder user(List<Account> list) {
            this.user = checkForNulls(list);
            return this;
        }

        public ResponseReferralList build() {
            return new ResponseReferralList(this);
        }
    }
}
