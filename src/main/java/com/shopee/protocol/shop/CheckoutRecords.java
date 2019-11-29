package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckoutRecords extends Message {
    public static final List<CheckoutRecord> DEFAULT_RECORDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CheckoutRecord.class, tag = 1)
    public final List<CheckoutRecord> records;

    public CheckoutRecords(List<CheckoutRecord> list) {
        this.records = immutableCopyOf(list);
    }

    private CheckoutRecords(Builder builder) {
        this(builder.records);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutRecords)) {
            return false;
        }
        return equals((List<?>) this.records, (List<?>) ((CheckoutRecords) obj).records);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<CheckoutRecord> list = this.records;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CheckoutRecords> {
        public List<CheckoutRecord> records;

        public Builder() {
        }

        public Builder(CheckoutRecords checkoutRecords) {
            super(checkoutRecords);
            if (checkoutRecords != null) {
                this.records = CheckoutRecords.copyOf(checkoutRecords.records);
            }
        }

        public Builder records(List<CheckoutRecord> list) {
            this.records = checkForNulls(list);
            return this;
        }

        public CheckoutRecords build() {
            return new CheckoutRecords(this);
        }
    }
}
