package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FlashSaleLogicInfo extends Message {
    public static final List<BrandSaleOutOfStockGroup> DEFAULT_GROUPS = Collections.emptyList();
    public static final List<FlashSaleOutOfStockItem> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = BrandSaleOutOfStockGroup.class, tag = 2)
    public final List<BrandSaleOutOfStockGroup> groups;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleOutOfStockItem.class, tag = 1)
    public final List<FlashSaleOutOfStockItem> items;

    public FlashSaleLogicInfo(List<FlashSaleOutOfStockItem> list, List<BrandSaleOutOfStockGroup> list2) {
        this.items = immutableCopyOf(list);
        this.groups = immutableCopyOf(list2);
    }

    private FlashSaleLogicInfo(Builder builder) {
        this(builder.items, builder.groups);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleLogicInfo)) {
            return false;
        }
        FlashSaleLogicInfo flashSaleLogicInfo = (FlashSaleLogicInfo) obj;
        if (!equals((List<?>) this.items, (List<?>) flashSaleLogicInfo.items) || !equals((List<?>) this.groups, (List<?>) flashSaleLogicInfo.groups)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<FlashSaleOutOfStockItem> list = this.items;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<BrandSaleOutOfStockGroup> list2 = this.groups;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FlashSaleLogicInfo> {
        public List<BrandSaleOutOfStockGroup> groups;
        public List<FlashSaleOutOfStockItem> items;

        public Builder() {
        }

        public Builder(FlashSaleLogicInfo flashSaleLogicInfo) {
            super(flashSaleLogicInfo);
            if (flashSaleLogicInfo != null) {
                this.items = FlashSaleLogicInfo.copyOf(flashSaleLogicInfo.items);
                this.groups = FlashSaleLogicInfo.copyOf(flashSaleLogicInfo.groups);
            }
        }

        public Builder items(List<FlashSaleOutOfStockItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder groups(List<BrandSaleOutOfStockGroup> list) {
            this.groups = checkForNulls(list);
            return this;
        }

        public FlashSaleLogicInfo build() {
            return new FlashSaleLogicInfo(this);
        }
    }
}
