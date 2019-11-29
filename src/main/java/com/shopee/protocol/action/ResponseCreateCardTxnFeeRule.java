package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCreateCardTxnFeeRule extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer rule_id;

    public ResponseCreateCardTxnFeeRule(String str, Integer num, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.rule_id = num2;
    }

    private ResponseCreateCardTxnFeeRule(Builder builder) {
        this(builder.requestid, builder.errcode, builder.rule_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCreateCardTxnFeeRule)) {
            return false;
        }
        ResponseCreateCardTxnFeeRule responseCreateCardTxnFeeRule = (ResponseCreateCardTxnFeeRule) obj;
        if (!equals((Object) this.requestid, (Object) responseCreateCardTxnFeeRule.requestid) || !equals((Object) this.errcode, (Object) responseCreateCardTxnFeeRule.errcode) || !equals((Object) this.rule_id, (Object) responseCreateCardTxnFeeRule.rule_id)) {
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
        Integer num2 = this.rule_id;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCreateCardTxnFeeRule> {
        public Integer errcode;
        public String requestid;
        public Integer rule_id;

        public Builder() {
        }

        public Builder(ResponseCreateCardTxnFeeRule responseCreateCardTxnFeeRule) {
            super(responseCreateCardTxnFeeRule);
            if (responseCreateCardTxnFeeRule != null) {
                this.requestid = responseCreateCardTxnFeeRule.requestid;
                this.errcode = responseCreateCardTxnFeeRule.errcode;
                this.rule_id = responseCreateCardTxnFeeRule.rule_id;
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

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public ResponseCreateCardTxnFeeRule build() {
            return new ResponseCreateCardTxnFeeRule(this);
        }
    }
}
