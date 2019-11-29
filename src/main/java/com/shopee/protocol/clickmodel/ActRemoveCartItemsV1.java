package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActRemoveCartItemsV1 extends Message {
    public static final List<String> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final String DEFAULT_SHOPID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> itemids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String shopid;

    public ActRemoveCartItemsV1(String str, List<String> list) {
        this.shopid = str;
        this.itemids = immutableCopyOf(list);
    }

    private ActRemoveCartItemsV1(Builder builder) {
        this(builder.shopid, builder.itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActRemoveCartItemsV1)) {
            return false;
        }
        ActRemoveCartItemsV1 actRemoveCartItemsV1 = (ActRemoveCartItemsV1) obj;
        if (!equals((Object) this.shopid, (Object) actRemoveCartItemsV1.shopid) || !equals((List<?>) this.itemids, (List<?>) actRemoveCartItemsV1.itemids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.shopid;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<String> list = this.itemids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ActRemoveCartItemsV1> {
        public List<String> itemids;
        public String shopid;

        public Builder() {
        }

        public Builder(ActRemoveCartItemsV1 actRemoveCartItemsV1) {
            super(actRemoveCartItemsV1);
            if (actRemoveCartItemsV1 != null) {
                this.shopid = actRemoveCartItemsV1.shopid;
                this.itemids = ActRemoveCartItemsV1.copyOf(actRemoveCartItemsV1.itemids);
            }
        }

        public Builder shopid(String str) {
            this.shopid = str;
            return this;
        }

        public Builder itemids(List<String> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public ActRemoveCartItemsV1 build() {
            return new ActRemoveCartItemsV1(this);
        }
    }
}
