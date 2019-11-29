package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CollectionItemExtInfo extends Message {
    public static final List<ClusterRecord> DEFAULT_ITEM_CLUSTER_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ClusterRecord.class, tag = 1)
    public final List<ClusterRecord> item_cluster_info;

    public CollectionItemExtInfo(List<ClusterRecord> list) {
        this.item_cluster_info = immutableCopyOf(list);
    }

    private CollectionItemExtInfo(Builder builder) {
        this(builder.item_cluster_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionItemExtInfo)) {
            return false;
        }
        return equals((List<?>) this.item_cluster_info, (List<?>) ((CollectionItemExtInfo) obj).item_cluster_info);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ClusterRecord> list = this.item_cluster_info;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CollectionItemExtInfo> {
        public List<ClusterRecord> item_cluster_info;

        public Builder() {
        }

        public Builder(CollectionItemExtInfo collectionItemExtInfo) {
            super(collectionItemExtInfo);
            if (collectionItemExtInfo != null) {
                this.item_cluster_info = CollectionItemExtInfo.copyOf(collectionItemExtInfo.item_cluster_info);
            }
        }

        public Builder item_cluster_info(List<ClusterRecord> list) {
            this.item_cluster_info = checkForNulls(list);
            return this;
        }

        public CollectionItemExtInfo build() {
            return new CollectionItemExtInfo(this);
        }
    }
}
