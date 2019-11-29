package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemRecord extends Message {
    public static final List<ItemCluster> DEFAULT_CLUSTER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCluster.class, tag = 1)
    public final List<ItemCluster> cluster;

    public ItemRecord(List<ItemCluster> list) {
        this.cluster = immutableCopyOf(list);
    }

    private ItemRecord(Builder builder) {
        this(builder.cluster);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemRecord)) {
            return false;
        }
        return equals((List<?>) this.cluster, (List<?>) ((ItemRecord) obj).cluster);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ItemCluster> list = this.cluster;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ItemRecord> {
        public List<ItemCluster> cluster;

        public Builder() {
        }

        public Builder(ItemRecord itemRecord) {
            super(itemRecord);
            if (itemRecord != null) {
                this.cluster = ItemRecord.copyOf(itemRecord.cluster);
            }
        }

        public Builder cluster(List<ItemCluster> list) {
            this.cluster = checkForNulls(list);
            return this;
        }

        public ItemRecord build() {
            return new ItemRecord(this);
        }
    }
}
