package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ClusterRecord extends Message {
    public static final List<UserClusterBehaviour> DEFAULT_CLUSTER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserClusterBehaviour.class, tag = 1)
    public final List<UserClusterBehaviour> cluster;

    public ClusterRecord(List<UserClusterBehaviour> list) {
        this.cluster = immutableCopyOf(list);
    }

    private ClusterRecord(Builder builder) {
        this(builder.cluster);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClusterRecord)) {
            return false;
        }
        return equals((List<?>) this.cluster, (List<?>) ((ClusterRecord) obj).cluster);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<UserClusterBehaviour> list = this.cluster;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ClusterRecord> {
        public List<UserClusterBehaviour> cluster;

        public Builder() {
        }

        public Builder(ClusterRecord clusterRecord) {
            super(clusterRecord);
            if (clusterRecord != null) {
                this.cluster = ClusterRecord.copyOf(clusterRecord.cluster);
            }
        }

        public Builder cluster(List<UserClusterBehaviour> list) {
            this.cluster = checkForNulls(list);
            return this;
        }

        public ClusterRecord build() {
            return new ClusterRecord(this);
        }
    }

    public enum Type implements ProtoEnum {
        RealTime(0),
        Batch(1),
        CFItemAffinity(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
