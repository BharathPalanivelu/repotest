package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShopCardTxnFeeSetting extends Message {
    public static final List<Integer> DEFAULT_FREE_CHANNEL_ID = Collections.emptyList();
    public static final List<TxnFeeCustomisedSetting> DEFAULT_FREE_RULES = Collections.emptyList();
    public static final List<TxnFeeSpecialGroupSetting> DEFAULT_GROUP_RULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> free_channel_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = TxnFeeCustomisedSetting.class, tag = 2)
    public final List<TxnFeeCustomisedSetting> free_rules;
    @ProtoField(label = Message.Label.REPEATED, messageType = TxnFeeSpecialGroupSetting.class, tag = 3)
    public final List<TxnFeeSpecialGroupSetting> group_rules;

    public ShopCardTxnFeeSetting(List<Integer> list, List<TxnFeeCustomisedSetting> list2, List<TxnFeeSpecialGroupSetting> list3) {
        this.free_channel_id = immutableCopyOf(list);
        this.free_rules = immutableCopyOf(list2);
        this.group_rules = immutableCopyOf(list3);
    }

    private ShopCardTxnFeeSetting(Builder builder) {
        this(builder.free_channel_id, builder.free_rules, builder.group_rules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCardTxnFeeSetting)) {
            return false;
        }
        ShopCardTxnFeeSetting shopCardTxnFeeSetting = (ShopCardTxnFeeSetting) obj;
        if (!equals((List<?>) this.free_channel_id, (List<?>) shopCardTxnFeeSetting.free_channel_id) || !equals((List<?>) this.free_rules, (List<?>) shopCardTxnFeeSetting.free_rules) || !equals((List<?>) this.group_rules, (List<?>) shopCardTxnFeeSetting.group_rules)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.free_channel_id;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<TxnFeeCustomisedSetting> list2 = this.free_rules;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<TxnFeeSpecialGroupSetting> list3 = this.group_rules;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCardTxnFeeSetting> {
        public List<Integer> free_channel_id;
        public List<TxnFeeCustomisedSetting> free_rules;
        public List<TxnFeeSpecialGroupSetting> group_rules;

        public Builder() {
        }

        public Builder(ShopCardTxnFeeSetting shopCardTxnFeeSetting) {
            super(shopCardTxnFeeSetting);
            if (shopCardTxnFeeSetting != null) {
                this.free_channel_id = ShopCardTxnFeeSetting.copyOf(shopCardTxnFeeSetting.free_channel_id);
                this.free_rules = ShopCardTxnFeeSetting.copyOf(shopCardTxnFeeSetting.free_rules);
                this.group_rules = ShopCardTxnFeeSetting.copyOf(shopCardTxnFeeSetting.group_rules);
            }
        }

        public Builder free_channel_id(List<Integer> list) {
            this.free_channel_id = checkForNulls(list);
            return this;
        }

        public Builder free_rules(List<TxnFeeCustomisedSetting> list) {
            this.free_rules = checkForNulls(list);
            return this;
        }

        public Builder group_rules(List<TxnFeeSpecialGroupSetting> list) {
            this.group_rules = checkForNulls(list);
            return this;
        }

        public ShopCardTxnFeeSetting build() {
            return new ShopCardTxnFeeSetting(this);
        }
    }
}
