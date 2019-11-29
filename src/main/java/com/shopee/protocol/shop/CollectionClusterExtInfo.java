package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CollectionClusterExtInfo extends Message {
    public static final List<ClusterRecord> DEFAULT_CLUSTER_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ClusterRecord.class, tag = 1)
    public final List<ClusterRecord> cluster_info;

    public CollectionClusterExtInfo(List<ClusterRecord> list) {
        this.cluster_info = immutableCopyOf(list);
    }

    private CollectionClusterExtInfo(Builder builder) {
        this(builder.cluster_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionClusterExtInfo)) {
            return false;
        }
        return equals((List<?>) this.cluster_info, (List<?>) ((CollectionClusterExtInfo) obj).cluster_info);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ClusterRecord> list = this.cluster_info;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CollectionClusterExtInfo> {
        public List<ClusterRecord> cluster_info;

        public Builder() {
        }

        public Builder(CollectionClusterExtInfo collectionClusterExtInfo) {
            super(collectionClusterExtInfo);
            if (collectionClusterExtInfo != null) {
                this.cluster_info = CollectionClusterExtInfo.copyOf(collectionClusterExtInfo.cluster_info);
            }
        }

        public Builder cluster_info(List<ClusterRecord> list) {
            this.cluster_info = checkForNulls(list);
            return this;
        }

        public CollectionClusterExtInfo build() {
            return new CollectionClusterExtInfo(this);
        }
    }
}
