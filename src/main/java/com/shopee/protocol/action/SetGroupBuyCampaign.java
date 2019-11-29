package com.shopee.protocol.action;

import com.shopee.protocol.shop.GroupBuyShopItemInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetGroupBuyCampaign extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_GROUP_BUY_CATID = 0;
    public static final Integer DEFAULT_GROUP_DURATION = 0;
    public static final Integer DEFAULT_PAYMENT_DURATION = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<GroupBuyShopItemInfo> DEFAULT_SHOP_ITEM_INFO = Collections.emptyList();
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_UNPAID_GROUP_NUM = 0;
    public static final Boolean DEFAULT_UPDATE_ITEM_REQUEST = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer group_buy_catid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer group_duration;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer payment_duration;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyShopItemInfo.class, tag = 5)
    public final List<GroupBuyShopItemInfo> shop_item_info;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer unpaid_group_num;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean update_item_request;

    public SetGroupBuyCampaign(String str, Long l, Integer num, Boolean bool, List<GroupBuyShopItemInfo> list, Integer num2, Integer num3, String str2, Integer num4, Integer num5, Integer num6) {
        this.requestid = str;
        this.campaignid = l;
        this.group_buy_catid = num;
        this.update_item_request = bool;
        this.shop_item_info = immutableCopyOf(list);
        this.start_time = num2;
        this.end_time = num3;
        this.country = str2;
        this.group_duration = num4;
        this.payment_duration = num5;
        this.unpaid_group_num = num6;
    }

    private SetGroupBuyCampaign(Builder builder) {
        this(builder.requestid, builder.campaignid, builder.group_buy_catid, builder.update_item_request, builder.shop_item_info, builder.start_time, builder.end_time, builder.country, builder.group_duration, builder.payment_duration, builder.unpaid_group_num);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetGroupBuyCampaign)) {
            return false;
        }
        SetGroupBuyCampaign setGroupBuyCampaign = (SetGroupBuyCampaign) obj;
        if (!equals((Object) this.requestid, (Object) setGroupBuyCampaign.requestid) || !equals((Object) this.campaignid, (Object) setGroupBuyCampaign.campaignid) || !equals((Object) this.group_buy_catid, (Object) setGroupBuyCampaign.group_buy_catid) || !equals((Object) this.update_item_request, (Object) setGroupBuyCampaign.update_item_request) || !equals((List<?>) this.shop_item_info, (List<?>) setGroupBuyCampaign.shop_item_info) || !equals((Object) this.start_time, (Object) setGroupBuyCampaign.start_time) || !equals((Object) this.end_time, (Object) setGroupBuyCampaign.end_time) || !equals((Object) this.country, (Object) setGroupBuyCampaign.country) || !equals((Object) this.group_duration, (Object) setGroupBuyCampaign.group_duration) || !equals((Object) this.payment_duration, (Object) setGroupBuyCampaign.payment_duration) || !equals((Object) this.unpaid_group_num, (Object) setGroupBuyCampaign.unpaid_group_num)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.campaignid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.group_buy_catid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.update_item_request;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<GroupBuyShopItemInfo> list = this.shop_item_info;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.start_time;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.group_duration;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.payment_duration;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.unpaid_group_num;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetGroupBuyCampaign> {
        public Long campaignid;
        public String country;
        public Integer end_time;
        public Integer group_buy_catid;
        public Integer group_duration;
        public Integer payment_duration;
        public String requestid;
        public List<GroupBuyShopItemInfo> shop_item_info;
        public Integer start_time;
        public Integer unpaid_group_num;
        public Boolean update_item_request;

        public Builder() {
        }

        public Builder(SetGroupBuyCampaign setGroupBuyCampaign) {
            super(setGroupBuyCampaign);
            if (setGroupBuyCampaign != null) {
                this.requestid = setGroupBuyCampaign.requestid;
                this.campaignid = setGroupBuyCampaign.campaignid;
                this.group_buy_catid = setGroupBuyCampaign.group_buy_catid;
                this.update_item_request = setGroupBuyCampaign.update_item_request;
                this.shop_item_info = SetGroupBuyCampaign.copyOf(setGroupBuyCampaign.shop_item_info);
                this.start_time = setGroupBuyCampaign.start_time;
                this.end_time = setGroupBuyCampaign.end_time;
                this.country = setGroupBuyCampaign.country;
                this.group_duration = setGroupBuyCampaign.group_duration;
                this.payment_duration = setGroupBuyCampaign.payment_duration;
                this.unpaid_group_num = setGroupBuyCampaign.unpaid_group_num;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder group_buy_catid(Integer num) {
            this.group_buy_catid = num;
            return this;
        }

        public Builder update_item_request(Boolean bool) {
            this.update_item_request = bool;
            return this;
        }

        public Builder shop_item_info(List<GroupBuyShopItemInfo> list) {
            this.shop_item_info = checkForNulls(list);
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder group_duration(Integer num) {
            this.group_duration = num;
            return this;
        }

        public Builder payment_duration(Integer num) {
            this.payment_duration = num;
            return this;
        }

        public Builder unpaid_group_num(Integer num) {
            this.unpaid_group_num = num;
            return this;
        }

        public SetGroupBuyCampaign build() {
            return new SetGroupBuyCampaign(this);
        }
    }
}
