package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopShipmentList extends Message {
    public static final List<ShopShipment> DEFAULT_SHOP_SHIPMENT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopShipment.class, tag = 1)
    public final List<ShopShipment> shop_shipment;

    public ShopShipmentList(List<ShopShipment> list) {
        this.shop_shipment = immutableCopyOf(list);
    }

    private ShopShipmentList(Builder builder) {
        this(builder.shop_shipment);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopShipmentList)) {
            return false;
        }
        return equals((List<?>) this.shop_shipment, (List<?>) ((ShopShipmentList) obj).shop_shipment);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ShopShipment> list = this.shop_shipment;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShopShipmentList> {
        public List<ShopShipment> shop_shipment;

        public Builder() {
        }

        public Builder(ShopShipmentList shopShipmentList) {
            super(shopShipmentList);
            if (shopShipmentList != null) {
                this.shop_shipment = ShopShipmentList.copyOf(shopShipmentList.shop_shipment);
            }
        }

        public Builder shop_shipment(List<ShopShipment> list) {
            this.shop_shipment = checkForNulls(list);
            return this;
        }

        public ShopShipmentList build() {
            return new ShopShipmentList(this);
        }
    }
}
