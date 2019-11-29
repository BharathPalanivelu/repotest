package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TxnFeeRuleExtinfo extends Message {
    public static final String DEFAULT_LEARN_MORE_URL = "";
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_ID = 0;
    public static final String DEFAULT_OPTION_INFO = "";
    public static final String DEFAULT_SUBLEVEL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final AdminFeeRule admin_fee_rule;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String learn_more_url;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer logistics_channel_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String option_info;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sublevel;

    public TxnFeeRuleExtinfo(String str, String str2, String str3, Integer num, AdminFeeRule adminFeeRule) {
        this.option_info = str;
        this.sublevel = str2;
        this.learn_more_url = str3;
        this.logistics_channel_id = num;
        this.admin_fee_rule = adminFeeRule;
    }

    private TxnFeeRuleExtinfo(Builder builder) {
        this(builder.option_info, builder.sublevel, builder.learn_more_url, builder.logistics_channel_id, builder.admin_fee_rule);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TxnFeeRuleExtinfo)) {
            return false;
        }
        TxnFeeRuleExtinfo txnFeeRuleExtinfo = (TxnFeeRuleExtinfo) obj;
        if (!equals((Object) this.option_info, (Object) txnFeeRuleExtinfo.option_info) || !equals((Object) this.sublevel, (Object) txnFeeRuleExtinfo.sublevel) || !equals((Object) this.learn_more_url, (Object) txnFeeRuleExtinfo.learn_more_url) || !equals((Object) this.logistics_channel_id, (Object) txnFeeRuleExtinfo.logistics_channel_id) || !equals((Object) this.admin_fee_rule, (Object) txnFeeRuleExtinfo.admin_fee_rule)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.option_info;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.sublevel;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.learn_more_url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.logistics_channel_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        AdminFeeRule adminFeeRule = this.admin_fee_rule;
        if (adminFeeRule != null) {
            i2 = adminFeeRule.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TxnFeeRuleExtinfo> {
        public AdminFeeRule admin_fee_rule;
        public String learn_more_url;
        public Integer logistics_channel_id;
        public String option_info;
        public String sublevel;

        public Builder() {
        }

        public Builder(TxnFeeRuleExtinfo txnFeeRuleExtinfo) {
            super(txnFeeRuleExtinfo);
            if (txnFeeRuleExtinfo != null) {
                this.option_info = txnFeeRuleExtinfo.option_info;
                this.sublevel = txnFeeRuleExtinfo.sublevel;
                this.learn_more_url = txnFeeRuleExtinfo.learn_more_url;
                this.logistics_channel_id = txnFeeRuleExtinfo.logistics_channel_id;
                this.admin_fee_rule = txnFeeRuleExtinfo.admin_fee_rule;
            }
        }

        public Builder option_info(String str) {
            this.option_info = str;
            return this;
        }

        public Builder sublevel(String str) {
            this.sublevel = str;
            return this;
        }

        public Builder learn_more_url(String str) {
            this.learn_more_url = str;
            return this;
        }

        public Builder logistics_channel_id(Integer num) {
            this.logistics_channel_id = num;
            return this;
        }

        public Builder admin_fee_rule(AdminFeeRule adminFeeRule) {
            this.admin_fee_rule = adminFeeRule;
            return this;
        }

        public TxnFeeRuleExtinfo build() {
            return new TxnFeeRuleExtinfo(this);
        }
    }
}
