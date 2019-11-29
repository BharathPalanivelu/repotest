package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderExtAdInfoMappings extends Message {
    public static final List<OrderExtAdInfo> DEFAULT_EXT_AD_INFOS = Collections.emptyList();
    public static final Integer DEFAULT_ITEMID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderExtAdInfo.class, tag = 2)
    public final List<OrderExtAdInfo> ext_ad_infos;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer itemid;

    public OrderExtAdInfoMappings(Integer num, List<OrderExtAdInfo> list) {
        this.itemid = num;
        this.ext_ad_infos = immutableCopyOf(list);
    }

    private OrderExtAdInfoMappings(Builder builder) {
        this(builder.itemid, builder.ext_ad_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderExtAdInfoMappings)) {
            return false;
        }
        OrderExtAdInfoMappings orderExtAdInfoMappings = (OrderExtAdInfoMappings) obj;
        if (!equals((Object) this.itemid, (Object) orderExtAdInfoMappings.itemid) || !equals((List<?>) this.ext_ad_infos, (List<?>) orderExtAdInfoMappings.ext_ad_infos)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.itemid;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<OrderExtAdInfo> list = this.ext_ad_infos;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<OrderExtAdInfoMappings> {
        public List<OrderExtAdInfo> ext_ad_infos;
        public Integer itemid;

        public Builder() {
        }

        public Builder(OrderExtAdInfoMappings orderExtAdInfoMappings) {
            super(orderExtAdInfoMappings);
            if (orderExtAdInfoMappings != null) {
                this.itemid = orderExtAdInfoMappings.itemid;
                this.ext_ad_infos = OrderExtAdInfoMappings.copyOf(orderExtAdInfoMappings.ext_ad_infos);
            }
        }

        public Builder itemid(Integer num) {
            this.itemid = num;
            return this;
        }

        public Builder ext_ad_infos(List<OrderExtAdInfo> list) {
            this.ext_ad_infos = checkForNulls(list);
            return this;
        }

        public OrderExtAdInfoMappings build() {
            return new OrderExtAdInfoMappings(this);
        }
    }
}
