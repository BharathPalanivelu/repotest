package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PaymentOptionList extends Message {
    public static final List<PaymentOption> DEFAULT_OPTION = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = PaymentOption.class, tag = 1)
    public final List<PaymentOption> option;

    public PaymentOptionList(List<PaymentOption> list) {
        this.option = immutableCopyOf(list);
    }

    private PaymentOptionList(Builder builder) {
        this(builder.option);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOptionList)) {
            return false;
        }
        return equals((List<?>) this.option, (List<?>) ((PaymentOptionList) obj).option);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<PaymentOption> list = this.option;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PaymentOptionList> {
        public List<PaymentOption> option;

        public Builder() {
        }

        public Builder(PaymentOptionList paymentOptionList) {
            super(paymentOptionList);
            if (paymentOptionList != null) {
                this.option = PaymentOptionList.copyOf(paymentOptionList.option);
            }
        }

        public Builder option(List<PaymentOption> list) {
            this.option = checkForNulls(list);
            return this;
        }

        public PaymentOptionList build() {
            return new PaymentOptionList(this);
        }
    }
}
