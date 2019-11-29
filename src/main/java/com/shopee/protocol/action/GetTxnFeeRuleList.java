package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetTxnFeeRuleList extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_RULE_ID = Collections.emptyList();
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> rule_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public GetTxnFeeRuleList(String str, Integer num, String str2, List<Integer> list) {
        this.requestid = str;
        this.type = num;
        this.country = str2;
        this.rule_id = immutableCopyOf(list);
    }

    private GetTxnFeeRuleList(Builder builder) {
        this(builder.requestid, builder.type, builder.country, builder.rule_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTxnFeeRuleList)) {
            return false;
        }
        GetTxnFeeRuleList getTxnFeeRuleList = (GetTxnFeeRuleList) obj;
        if (!equals((Object) this.requestid, (Object) getTxnFeeRuleList.requestid) || !equals((Object) this.type, (Object) getTxnFeeRuleList.type) || !equals((Object) this.country, (Object) getTxnFeeRuleList.country) || !equals((List<?>) this.rule_id, (List<?>) getTxnFeeRuleList.rule_id)) {
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
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<Integer> list = this.rule_id;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<GetTxnFeeRuleList> {
        public String country;
        public String requestid;
        public List<Integer> rule_id;
        public Integer type;

        public Builder() {
        }

        public Builder(GetTxnFeeRuleList getTxnFeeRuleList) {
            super(getTxnFeeRuleList);
            if (getTxnFeeRuleList != null) {
                this.requestid = getTxnFeeRuleList.requestid;
                this.type = getTxnFeeRuleList.type;
                this.country = getTxnFeeRuleList.country;
                this.rule_id = GetTxnFeeRuleList.copyOf(getTxnFeeRuleList.rule_id);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder rule_id(List<Integer> list) {
            this.rule_id = checkForNulls(list);
            return this;
        }

        public GetTxnFeeRuleList build() {
            return new GetTxnFeeRuleList(this);
        }
    }
}
