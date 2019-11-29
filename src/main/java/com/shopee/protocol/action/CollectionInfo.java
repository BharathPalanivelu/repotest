package com.shopee.protocol.action;

import com.shopee.protocol.shop.ClusterRecord;
import com.shopee.protocol.shop.Collection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CollectionInfo extends Message {
    public static final List<ClusterRecord> DEFAULT_CLUSTER_INFO = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ClusterRecord.class, tag = 2)
    public final List<ClusterRecord> cluster_info;
    @ProtoField(tag = 1)
    public final Collection collection;

    public CollectionInfo(Collection collection2, List<ClusterRecord> list) {
        this.collection = collection2;
        this.cluster_info = immutableCopyOf(list);
    }

    private CollectionInfo(Builder builder) {
        this(builder.collection, builder.cluster_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionInfo)) {
            return false;
        }
        CollectionInfo collectionInfo = (CollectionInfo) obj;
        if (!equals((Object) this.collection, (Object) collectionInfo.collection) || !equals((List<?>) this.cluster_info, (List<?>) collectionInfo.cluster_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Collection collection2 = this.collection;
        int hashCode = (collection2 != null ? collection2.hashCode() : 0) * 37;
        List<ClusterRecord> list = this.cluster_info;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CollectionInfo> {
        public List<ClusterRecord> cluster_info;
        public Collection collection;

        public Builder() {
        }

        public Builder(CollectionInfo collectionInfo) {
            super(collectionInfo);
            if (collectionInfo != null) {
                this.collection = collectionInfo.collection;
                this.cluster_info = CollectionInfo.copyOf(collectionInfo.cluster_info);
            }
        }

        public Builder collection(Collection collection2) {
            this.collection = collection2;
            return this;
        }

        public Builder cluster_info(List<ClusterRecord> list) {
            this.cluster_info = checkForNulls(list);
            return this;
        }

        public CollectionInfo build() {
            return new CollectionInfo(this);
        }
    }
}
