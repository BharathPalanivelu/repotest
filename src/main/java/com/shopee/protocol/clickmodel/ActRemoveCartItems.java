package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActRemoveCartItems extends Message {
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public ActRemoveCartItems(Integer num, List<Long> list) {
        this.shopid = num;
        this.itemids = immutableCopyOf(list);
    }

    private ActRemoveCartItems(Builder builder) {
        this(builder.shopid, builder.itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActRemoveCartItems)) {
            return false;
        }
        ActRemoveCartItems actRemoveCartItems = (ActRemoveCartItems) obj;
        if (!equals((Object) this.shopid, (Object) actRemoveCartItems.shopid) || !equals((List<?>) this.itemids, (List<?>) actRemoveCartItems.itemids)) {
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
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Long> list = this.itemids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ActRemoveCartItems> {
        public List<Long> itemids;
        public Integer shopid;

        public Builder() {
        }

        public Builder(ActRemoveCartItems actRemoveCartItems) {
            super(actRemoveCartItems);
            if (actRemoveCartItems != null) {
                this.shopid = actRemoveCartItems.shopid;
                this.itemids = ActRemoveCartItems.copyOf(actRemoveCartItems.itemids);
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public ActRemoveCartItems build() {
            return new ActRemoveCartItems(this);
        }
    }
}
