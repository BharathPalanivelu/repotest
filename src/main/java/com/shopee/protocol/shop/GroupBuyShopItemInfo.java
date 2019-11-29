package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GroupBuyShopItemInfo extends Message {
    public static final List<String> DEFAULT_CUSTOM_IMAGES = Collections.emptyList();
    public static final String DEFAULT_CUSTOM_NAME = "";
    public static final Integer DEFAULT_GROUP_BUY_CATID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERS_PAID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> custom_images;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String custom_name;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer group_buy_catid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer users_paid;

    public GroupBuyShopItemInfo(Integer num, Long l, Integer num2, String str, List<String> list, Integer num3) {
        this.shopid = num;
        this.itemid = l;
        this.group_buy_catid = num2;
        this.custom_name = str;
        this.custom_images = immutableCopyOf(list);
        this.users_paid = num3;
    }

    private GroupBuyShopItemInfo(Builder builder) {
        this(builder.shopid, builder.itemid, builder.group_buy_catid, builder.custom_name, builder.custom_images, builder.users_paid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyShopItemInfo)) {
            return false;
        }
        GroupBuyShopItemInfo groupBuyShopItemInfo = (GroupBuyShopItemInfo) obj;
        if (!equals((Object) this.shopid, (Object) groupBuyShopItemInfo.shopid) || !equals((Object) this.itemid, (Object) groupBuyShopItemInfo.itemid) || !equals((Object) this.group_buy_catid, (Object) groupBuyShopItemInfo.group_buy_catid) || !equals((Object) this.custom_name, (Object) groupBuyShopItemInfo.custom_name) || !equals((List<?>) this.custom_images, (List<?>) groupBuyShopItemInfo.custom_images) || !equals((Object) this.users_paid, (Object) groupBuyShopItemInfo.users_paid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.group_buy_catid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.custom_name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        List<String> list = this.custom_images;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.users_paid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyShopItemInfo> {
        public List<String> custom_images;
        public String custom_name;
        public Integer group_buy_catid;
        public Long itemid;
        public Integer shopid;
        public Integer users_paid;

        public Builder() {
        }

        public Builder(GroupBuyShopItemInfo groupBuyShopItemInfo) {
            super(groupBuyShopItemInfo);
            if (groupBuyShopItemInfo != null) {
                this.shopid = groupBuyShopItemInfo.shopid;
                this.itemid = groupBuyShopItemInfo.itemid;
                this.group_buy_catid = groupBuyShopItemInfo.group_buy_catid;
                this.custom_name = groupBuyShopItemInfo.custom_name;
                this.custom_images = GroupBuyShopItemInfo.copyOf(groupBuyShopItemInfo.custom_images);
                this.users_paid = groupBuyShopItemInfo.users_paid;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder group_buy_catid(Integer num) {
            this.group_buy_catid = num;
            return this;
        }

        public Builder custom_name(String str) {
            this.custom_name = str;
            return this;
        }

        public Builder custom_images(List<String> list) {
            this.custom_images = checkForNulls(list);
            return this;
        }

        public Builder users_paid(Integer num) {
            this.users_paid = num;
            return this;
        }

        public GroupBuyShopItemInfo build() {
            return new GroupBuyShopItemInfo(this);
        }
    }
}
