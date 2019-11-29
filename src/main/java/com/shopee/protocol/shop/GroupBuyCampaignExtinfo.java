package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GroupBuyCampaignExtinfo extends Message {
    public static final List<GroupBuyShopItemInfo> DEFAULT_SHOP_ITEM_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyShopItemInfo.class, tag = 1)
    public final List<GroupBuyShopItemInfo> shop_item_info;

    public GroupBuyCampaignExtinfo(List<GroupBuyShopItemInfo> list) {
        this.shop_item_info = immutableCopyOf(list);
    }

    private GroupBuyCampaignExtinfo(Builder builder) {
        this(builder.shop_item_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyCampaignExtinfo)) {
            return false;
        }
        return equals((List<?>) this.shop_item_info, (List<?>) ((GroupBuyCampaignExtinfo) obj).shop_item_info);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<GroupBuyShopItemInfo> list = this.shop_item_info;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GroupBuyCampaignExtinfo> {
        public List<GroupBuyShopItemInfo> shop_item_info;

        public Builder() {
        }

        public Builder(GroupBuyCampaignExtinfo groupBuyCampaignExtinfo) {
            super(groupBuyCampaignExtinfo);
            if (groupBuyCampaignExtinfo != null) {
                this.shop_item_info = GroupBuyCampaignExtinfo.copyOf(groupBuyCampaignExtinfo.shop_item_info);
            }
        }

        public Builder shop_item_info(List<GroupBuyShopItemInfo> list) {
            this.shop_item_info = checkForNulls(list);
            return this;
        }

        public GroupBuyCampaignExtinfo build() {
            return new GroupBuyCampaignExtinfo(this);
        }
    }
}
