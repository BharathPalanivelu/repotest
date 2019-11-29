package com.shopee.protocol.action;

import com.shopee.protocol.shop.CardTxnFeeRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CreateCardTxnFeeRule extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2)
    public final CardTxnFeeRule rule;

    public CreateCardTxnFeeRule(String str, CardTxnFeeRule cardTxnFeeRule) {
        this.requestid = str;
        this.rule = cardTxnFeeRule;
    }

    private CreateCardTxnFeeRule(Builder builder) {
        this(builder.requestid, builder.rule);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCardTxnFeeRule)) {
            return false;
        }
        CreateCardTxnFeeRule createCardTxnFeeRule = (CreateCardTxnFeeRule) obj;
        if (!equals((Object) this.requestid, (Object) createCardTxnFeeRule.requestid) || !equals((Object) this.rule, (Object) createCardTxnFeeRule.rule)) {
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
        CardTxnFeeRule cardTxnFeeRule = this.rule;
        if (cardTxnFeeRule != null) {
            i2 = cardTxnFeeRule.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateCardTxnFeeRule> {
        public String requestid;
        public CardTxnFeeRule rule;

        public Builder() {
        }

        public Builder(CreateCardTxnFeeRule createCardTxnFeeRule) {
            super(createCardTxnFeeRule);
            if (createCardTxnFeeRule != null) {
                this.requestid = createCardTxnFeeRule.requestid;
                this.rule = createCardTxnFeeRule.rule;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder rule(CardTxnFeeRule cardTxnFeeRule) {
            this.rule = cardTxnFeeRule;
            return this;
        }

        public CreateCardTxnFeeRule build() {
            return new CreateCardTxnFeeRule(this);
        }
    }
}
