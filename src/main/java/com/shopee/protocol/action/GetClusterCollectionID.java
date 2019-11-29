package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetClusterCollectionID extends Message {
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cluster_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetClusterCollectionID(String str, String str2) {
        this.requestid = str;
        this.cluster_id = str2;
    }

    private GetClusterCollectionID(Builder builder) {
        this(builder.requestid, builder.cluster_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetClusterCollectionID)) {
            return false;
        }
        GetClusterCollectionID getClusterCollectionID = (GetClusterCollectionID) obj;
        if (!equals((Object) this.requestid, (Object) getClusterCollectionID.requestid) || !equals((Object) this.cluster_id, (Object) getClusterCollectionID.cluster_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.cluster_id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetClusterCollectionID> {
        public String cluster_id;
        public String requestid;

        public Builder() {
        }

        public Builder(GetClusterCollectionID getClusterCollectionID) {
            super(getClusterCollectionID);
            if (getClusterCollectionID != null) {
                this.requestid = getClusterCollectionID.requestid;
                this.cluster_id = getClusterCollectionID.cluster_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder cluster_id(String str) {
            this.cluster_id = str;
            return this;
        }

        public GetClusterCollectionID build() {
            return new GetClusterCollectionID(this);
        }
    }
}
