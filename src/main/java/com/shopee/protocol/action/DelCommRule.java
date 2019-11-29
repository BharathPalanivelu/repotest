package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelCommRule extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer rule_id;

    public DelCommRule(String str, Integer num) {
        this.requestid = str;
        this.rule_id = num;
    }

    private DelCommRule(Builder builder) {
        this(builder.requestid, builder.rule_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelCommRule)) {
            return false;
        }
        DelCommRule delCommRule = (DelCommRule) obj;
        if (!equals((Object) this.requestid, (Object) delCommRule.requestid) || !equals((Object) this.rule_id, (Object) delCommRule.rule_id)) {
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
        Integer num = this.rule_id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelCommRule> {
        public String requestid;
        public Integer rule_id;

        public Builder() {
        }

        public Builder(DelCommRule delCommRule) {
            super(delCommRule);
            if (delCommRule != null) {
                this.requestid = delCommRule.requestid;
                this.rule_id = delCommRule.rule_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public DelCommRule build() {
            return new DelCommRule(this);
        }
    }
}
