package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GroupBuyGroupExtinfo extends Message {
    public static final List<GroupOrderBrief> DEFAULT_ORDERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupOrderBrief.class, tag = 1)
    public final List<GroupOrderBrief> orders;

    public GroupBuyGroupExtinfo(List<GroupOrderBrief> list) {
        this.orders = immutableCopyOf(list);
    }

    private GroupBuyGroupExtinfo(Builder builder) {
        this(builder.orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyGroupExtinfo)) {
            return false;
        }
        return equals((List<?>) this.orders, (List<?>) ((GroupBuyGroupExtinfo) obj).orders);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<GroupOrderBrief> list = this.orders;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GroupBuyGroupExtinfo> {
        public List<GroupOrderBrief> orders;

        public Builder() {
        }

        public Builder(GroupBuyGroupExtinfo groupBuyGroupExtinfo) {
            super(groupBuyGroupExtinfo);
            if (groupBuyGroupExtinfo != null) {
                this.orders = GroupBuyGroupExtinfo.copyOf(groupBuyGroupExtinfo.orders);
            }
        }

        public Builder orders(List<GroupOrderBrief> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public GroupBuyGroupExtinfo build() {
            return new GroupBuyGroupExtinfo(this);
        }
    }
}
