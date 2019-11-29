package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PricingTaskItems extends Message {
    public static final List<ItemCrawls> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCrawls.class, tag = 1)
    public final List<ItemCrawls> items;

    public PricingTaskItems(List<ItemCrawls> list) {
        this.items = immutableCopyOf(list);
    }

    private PricingTaskItems(Builder builder) {
        this(builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PricingTaskItems)) {
            return false;
        }
        return equals((List<?>) this.items, (List<?>) ((PricingTaskItems) obj).items);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ItemCrawls> list = this.items;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PricingTaskItems> {
        public List<ItemCrawls> items;

        public Builder() {
        }

        public Builder(PricingTaskItems pricingTaskItems) {
            super(pricingTaskItems);
            if (pricingTaskItems != null) {
                this.items = PricingTaskItems.copyOf(pricingTaskItems.items);
            }
        }

        public Builder items(List<ItemCrawls> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public PricingTaskItems build() {
            return new PricingTaskItems(this);
        }
    }
}
