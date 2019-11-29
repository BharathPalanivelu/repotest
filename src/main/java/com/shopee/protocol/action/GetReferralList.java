package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetReferralList extends Message {
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetReferralList(String str, String str2, Integer num, Integer num2) {
        this.requestid = str;
        this.token = str2;
        this.offset = num;
        this.limit = num2;
    }

    private GetReferralList(Builder builder) {
        this(builder.requestid, builder.token, builder.offset, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetReferralList)) {
            return false;
        }
        GetReferralList getReferralList = (GetReferralList) obj;
        if (!equals((Object) this.requestid, (Object) getReferralList.requestid) || !equals((Object) this.token, (Object) getReferralList.token) || !equals((Object) this.offset, (Object) getReferralList.offset) || !equals((Object) this.limit, (Object) getReferralList.limit)) {
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
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetReferralList> {
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetReferralList getReferralList) {
            super(getReferralList);
            if (getReferralList != null) {
                this.requestid = getReferralList.requestid;
                this.token = getReferralList.token;
                this.offset = getReferralList.offset;
                this.limit = getReferralList.limit;
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

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public GetReferralList build() {
            return new GetReferralList(this);
        }
    }
}
