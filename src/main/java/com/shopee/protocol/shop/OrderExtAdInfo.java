package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderExtAdInfo extends Message {
    public static final Integer DEFAULT_AD_TRACKING_TIME = 0;
    public static final String DEFAULT_EXT_AD_DATA = "";
    public static final Integer DEFAULT_EXT_AD_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ad_tracking_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String ext_ad_data;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ext_ad_id;

    public OrderExtAdInfo(Integer num, Integer num2, String str) {
        this.ext_ad_id = num;
        this.ad_tracking_time = num2;
        this.ext_ad_data = str;
    }

    private OrderExtAdInfo(Builder builder) {
        this(builder.ext_ad_id, builder.ad_tracking_time, builder.ext_ad_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderExtAdInfo)) {
            return false;
        }
        OrderExtAdInfo orderExtAdInfo = (OrderExtAdInfo) obj;
        if (!equals((Object) this.ext_ad_id, (Object) orderExtAdInfo.ext_ad_id) || !equals((Object) this.ad_tracking_time, (Object) orderExtAdInfo.ad_tracking_time) || !equals((Object) this.ext_ad_data, (Object) orderExtAdInfo.ext_ad_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ext_ad_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.ad_tracking_time;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.ext_ad_data;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderExtAdInfo> {
        public Integer ad_tracking_time;
        public String ext_ad_data;
        public Integer ext_ad_id;

        public Builder() {
        }

        public Builder(OrderExtAdInfo orderExtAdInfo) {
            super(orderExtAdInfo);
            if (orderExtAdInfo != null) {
                this.ext_ad_id = orderExtAdInfo.ext_ad_id;
                this.ad_tracking_time = orderExtAdInfo.ad_tracking_time;
                this.ext_ad_data = orderExtAdInfo.ext_ad_data;
            }
        }

        public Builder ext_ad_id(Integer num) {
            this.ext_ad_id = num;
            return this;
        }

        public Builder ad_tracking_time(Integer num) {
            this.ad_tracking_time = num;
            return this;
        }

        public Builder ext_ad_data(String str) {
            this.ext_ad_data = str;
            return this;
        }

        public OrderExtAdInfo build() {
            return new OrderExtAdInfo(this);
        }
    }
}
