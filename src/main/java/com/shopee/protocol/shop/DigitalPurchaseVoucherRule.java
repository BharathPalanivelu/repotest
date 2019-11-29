package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DigitalPurchaseVoucherRule extends Message {
    public static final List<Long> DEFAULT_CARRIERS = Collections.emptyList();
    public static final List<Long> DEFAULT_DISABLE_CARRIERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> carriers;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> disable_carriers;

    public DigitalPurchaseVoucherRule(List<Long> list, List<Long> list2) {
        this.carriers = immutableCopyOf(list);
        this.disable_carriers = immutableCopyOf(list2);
    }

    private DigitalPurchaseVoucherRule(Builder builder) {
        this(builder.carriers, builder.disable_carriers);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DigitalPurchaseVoucherRule)) {
            return false;
        }
        DigitalPurchaseVoucherRule digitalPurchaseVoucherRule = (DigitalPurchaseVoucherRule) obj;
        if (!equals((List<?>) this.carriers, (List<?>) digitalPurchaseVoucherRule.carriers) || !equals((List<?>) this.disable_carriers, (List<?>) digitalPurchaseVoucherRule.disable_carriers)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.carriers;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Long> list2 = this.disable_carriers;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DigitalPurchaseVoucherRule> {
        public List<Long> carriers;
        public List<Long> disable_carriers;

        public Builder() {
        }

        public Builder(DigitalPurchaseVoucherRule digitalPurchaseVoucherRule) {
            super(digitalPurchaseVoucherRule);
            if (digitalPurchaseVoucherRule != null) {
                this.carriers = DigitalPurchaseVoucherRule.copyOf(digitalPurchaseVoucherRule.carriers);
                this.disable_carriers = DigitalPurchaseVoucherRule.copyOf(digitalPurchaseVoucherRule.disable_carriers);
            }
        }

        public Builder carriers(List<Long> list) {
            this.carriers = checkForNulls(list);
            return this;
        }

        public Builder disable_carriers(List<Long> list) {
            this.disable_carriers = checkForNulls(list);
            return this;
        }

        public DigitalPurchaseVoucherRule build() {
            return new DigitalPurchaseVoucherRule(this);
        }
    }
}
