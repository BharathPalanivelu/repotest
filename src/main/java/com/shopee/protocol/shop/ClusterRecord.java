package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ClusterRecord extends Message {
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;

    public ClusterRecord(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    private ClusterRecord(Builder builder) {
        this(builder.id, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClusterRecord)) {
            return false;
        }
        ClusterRecord clusterRecord = (ClusterRecord) obj;
        if (!equals((Object) this.id, (Object) clusterRecord.id) || !equals((Object) this.name, (Object) clusterRecord.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ClusterRecord> {
        public String id;
        public String name;

        public Builder() {
        }

        public Builder(ClusterRecord clusterRecord) {
            super(clusterRecord);
            if (clusterRecord != null) {
                this.id = clusterRecord.id;
                this.name = clusterRecord.name;
            }
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public ClusterRecord build() {
            return new ClusterRecord(this);
        }
    }
}
