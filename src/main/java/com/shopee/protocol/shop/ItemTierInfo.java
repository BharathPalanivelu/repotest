package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemTierInfo extends Message {
    public static final Boolean DEFAULT_CAN_USE_WHOLESALE = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<WholesaleTier> DEFAULT_WHOLESALE_TIER_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean can_use_wholesale;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = WholesaleTier.class, tag = 3)
    public final List<WholesaleTier> wholesale_tier_list;

    public ItemTierInfo(Long l, Boolean bool, List<WholesaleTier> list) {
        this.itemid = l;
        this.can_use_wholesale = bool;
        this.wholesale_tier_list = immutableCopyOf(list);
    }

    private ItemTierInfo(Builder builder) {
        this(builder.itemid, builder.can_use_wholesale, builder.wholesale_tier_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemTierInfo)) {
            return false;
        }
        ItemTierInfo itemTierInfo = (ItemTierInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemTierInfo.itemid) || !equals((Object) this.can_use_wholesale, (Object) itemTierInfo.can_use_wholesale) || !equals((List<?>) this.wholesale_tier_list, (List<?>) itemTierInfo.wholesale_tier_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Boolean bool = this.can_use_wholesale;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<WholesaleTier> list = this.wholesale_tier_list;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ItemTierInfo> {
        public Boolean can_use_wholesale;
        public Long itemid;
        public List<WholesaleTier> wholesale_tier_list;

        public Builder() {
        }

        public Builder(ItemTierInfo itemTierInfo) {
            super(itemTierInfo);
            if (itemTierInfo != null) {
                this.itemid = itemTierInfo.itemid;
                this.can_use_wholesale = itemTierInfo.can_use_wholesale;
                this.wholesale_tier_list = ItemTierInfo.copyOf(itemTierInfo.wholesale_tier_list);
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder can_use_wholesale(Boolean bool) {
            this.can_use_wholesale = bool;
            return this;
        }

        public Builder wholesale_tier_list(List<WholesaleTier> list) {
            this.wholesale_tier_list = checkForNulls(list);
            return this;
        }

        public ItemTierInfo build() {
            checkRequiredFields();
            return new ItemTierInfo(this);
        }
    }
}
