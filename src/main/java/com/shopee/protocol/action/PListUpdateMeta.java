package com.shopee.protocol.action;

import com.shopee.protocol.shop.Item;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PListUpdateMeta extends Message {
    public static final Double DEFAULT_RANDOM_VALUE = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final Item item_info;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double random_value;

    public PListUpdateMeta(Item item, Double d2) {
        this.item_info = item;
        this.random_value = d2;
    }

    private PListUpdateMeta(Builder builder) {
        this(builder.item_info, builder.random_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListUpdateMeta)) {
            return false;
        }
        PListUpdateMeta pListUpdateMeta = (PListUpdateMeta) obj;
        if (!equals((Object) this.item_info, (Object) pListUpdateMeta.item_info) || !equals((Object) this.random_value, (Object) pListUpdateMeta.random_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Item item = this.item_info;
        int i2 = 0;
        int hashCode = (item != null ? item.hashCode() : 0) * 37;
        Double d2 = this.random_value;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListUpdateMeta> {
        public Item item_info;
        public Double random_value;

        public Builder() {
        }

        public Builder(PListUpdateMeta pListUpdateMeta) {
            super(pListUpdateMeta);
            if (pListUpdateMeta != null) {
                this.item_info = pListUpdateMeta.item_info;
                this.random_value = pListUpdateMeta.random_value;
            }
        }

        public Builder item_info(Item item) {
            this.item_info = item;
            return this;
        }

        public Builder random_value(Double d2) {
            this.random_value = d2;
            return this;
        }

        public PListUpdateMeta build() {
            checkRequiredFields();
            return new PListUpdateMeta(this);
        }
    }
}
